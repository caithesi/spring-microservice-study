#!/bin/bash

systemctl --user stop licensing-service.service
systemctl --user stop config-service.service
systemctl --user stop eureka-service.service
systemctl --user stop ostock-network.service
