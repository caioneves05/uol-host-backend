terraform {
  required_providers {
    aws = {
      source  = "hashicorp/aws"
      version = "5.49.0"
    }
  }

  backend "s3" {
    bucket =  "uol-host-terraform-state"
    key    = "state/terraform.tfstate"
    region = "us-east-2"
  }
}

provider "aws" {
  region  = "us-east-2"
  profile = "caioeniac"
}

resource "aws_s3_bucket" "terraform_state" {
    bucket = "uol-host-terraform-state"
    acl    = "private"
    force_destroy = true

    lifecycle {
      prevent_destroy = true
    }

    tags = {
        iac         = "true"
        profile     = "caioeniac"
        environment = "dev"
    }
}

resource "aws_s3_bucket_versioning" "terraform_state_versioning" {
  bucket = aws_s3_bucket.terraform_state.id
  versioning_configuration {
    status = "Enabled"
  }
}