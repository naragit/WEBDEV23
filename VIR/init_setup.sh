#!/bin/bash

sudo yum update -y
sudo yum provides -y /usr/sbin/semanage
sudo yum install -y policycoreutils-python

## Repo update
sudo cat <<EOF > /etc/yum.repos.d/kubernetes.repo
[kubernetes]
name=Kubernetes
baseurl=https://packages.cloud.google.com/yum/repos/kubernetes-el7-x86_64
enabled=1
gpgcheck=1
repo_gpgcheck=1
gpgkey=https://packages.cloud.google.com/yum/doc/yum-key.gpg https://packages.cloud.google.com/yum/doc/rpm-package-key.gpg
EOF

##

sudo ls -ltr /etc/yum.repos.d
sleep 2
sudo yum install -y kubectl 
sleep 2
curl -sfL https://get.k3s.io | sh -
sleep 2

USER_DIR=/home/vagrant
sudo mkdir -p $USER_DIR/.kube
sudo cp /etc/rancher/k3s/k3s.yaml $USER_DIR/.kube/config
sudo chown -R  vagrant:vagrant  $USER_DIR/.kube
## sudo -u vagrant chown $(id -u):$(id -g) $USER_DIR/.kube/config
echo "Install Completed --> `date` "

