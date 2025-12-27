resource "aws_ecr_repository" "uol-host-backend-ci" {
  name                 = "uol-host-backend-ci"
  image_tag_mutability = "MUTABLE"
  image_scanning_configuration {
    scan_on_push = true
  }

  tags = {
    iac         = "true"
    profile     = "github-actions"
    environment = "dev"
  }
}