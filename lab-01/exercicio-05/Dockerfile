FROM python:3.14-slim

WORKDIR /app

RUN pip install flask redis

ENV FLASK_APP=app.py
ENV FLASK_RUN_HOST=0.0.0.0
ENV PYTHONUNBUFFERED=1

EXPOSE 5000

CMD [ "flask" , "run" ]
