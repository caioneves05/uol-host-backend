resource "aws_iam_openid_connect_provider" "oidc_github" {
  url             = "https://token.actions.githubusercontent.com"
  client_id_list  = ["sts.amazonaws.com"]
  thumbprint_list = ["7560d6f40fa55195f740ee2b1b7c0b4836cbe103"]

  tags = {
    iac         = "true"
    profile     = "github-actions"
    environment = "dev"
  }
}

resource "aws_iam_role" "app-runner-role" {
  name = "app-runner-role"
  assume_role_policy = jsonencode({
    "Version" : "2012-10-17",
    "Statement" : [
      {
        "Sid" : "Statement1",
        "Effect" : "Allow",
        "Principal" : {
          "Service" : "build.apprunner.amazonaws.com"
        },
        "Action" : "sts:AssumeRole"
      }
    ]

  })

  managed_policy_arns = [
    "arn:aws:iam::aws:policy/AmazonEC2ContainerRegistryReadOnly"
  ]

  tags = {
    iac         = "true"
    profile     = "github-actions"
    environment = "dev"
  }
}

resource "aws_iam_role" "role_github_actions-ecr" {
  name = "role_github_actions-ecr"
  assume_role_policy = jsonencode({
    "Version" : "2012-10-17",
    "Statement" : [
      {
        "Effect" : "Allow",
        "Action" : "sts:AssumeRoleWithWebIdentity",
        "Principal" : {
          "Federated" : "arn:aws:iam::602151477390:oidc-provider/token.actions.githubusercontent.com"
        },
        "Condition" : {
          "StringEquals" : {
            "token.actions.githubusercontent.com:aud" : [
              "sts.amazonaws.com"
            ]
          },
          "StringLike" : {
            "token.actions.githubusercontent.com:sub" : [
              "repo:caioneves05/uol-host-backend:ref:refs/heads/main",
              "repo:caioneves05/uol-host-backend:ref:refs/heads/main"
            ]
          }
        }
      }
    ]
  })

  inline_policy {
    name = "policy-github-actions-ecr"
    policy = jsonencode({
      "Version" : "2012-10-17",
      "Statement" : [
        {
          "Sid" : "statement1",
          Action : "appRunner:*",
          "Effect" : "Allow",
          "Resource" : "*"
        },
        {
          "Sid" : "statement2",
          Action : [
            "iam:PassRole",
            "iam:CreateServiceLinkedRole",
          ],
          "Effect" : "Allow",
          "Resource" : "*"
        },
        {
          "Sid" : "statement3",
          "Effect" : "Allow",
          "Action" : [
            "ecr:GetAuthorizationToken",
            "ecr:BatchCheckLayerAvailability",
            "ecr:GetDownloadUrlForLayer",
            "ecr:BatchGetImage",
            "ecr:PutImage",
            "ecr:InitiateLayerUpload",
            "ecr:UploadLayerPart",
            "ecr:CompleteLayerUpload"
          ],
          "Resource" : "*"
        }
      ]
    })
  }

  tags = {
    iac         = "true"
    profile     = "github-actions"
    environment = "dev"
  }
}