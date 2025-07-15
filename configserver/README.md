# spring cloud config server created while im learing microservice

# please check two build script, build.sh is writen for docker, while build_podman.sh is writen for podman

# script for podman was more complete due to it is created for my potato laptop, which cant handle docker

# then the iamge was push to docker hub under docker://docker.io/caithesi/ostock-licensing-service:latest

# and deploy to render at https://dashboard.render.com/web/srv-d1dvlabipnbc73dou9d0/deploys/dep-d1dvlajipnbc73dou9ig

# you can check some resource here

# https://sict-ostock-licensing-service.onrender.com/licensing-service/dev

# config using Configuration Files with Profile Groups

How This Works

Profile Groups: Each service defines its own profile groups in its base configuration file
Automatic Resolution: When a service requests configuration:

Default profile → gets base service config + profiles defined in default group
Dev profile → gets base service config + dev overrides + profiles defined in dev group


Minimal Client Changes: Clients only need to specify their application name and active profile