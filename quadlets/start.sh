#!/bin/bash

systemctl --user start ostock-network.service
systemctl --user start config-service.service
systemctl --user start eureka-service.service
systemctl --user start licensing-service.service
