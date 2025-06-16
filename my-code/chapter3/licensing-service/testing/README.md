## this test was created due to my machine is too old to using postman

## this test was designed with python, and some lib like requests

## set up
### 1. using virtual environment python

due to ubuntu 24.04 no more encourage using pip, and, using pip may violate global env

requirement: python 3.11, python3-venv installed
```bash
python3 -m venv .venv
source .venv/bin/activate
pip install -r requirements.txt 
```
### 2. when there are new dependencies, please update requirements.txt
```bash
pip freeze > requirements.txt
```