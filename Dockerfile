FROM python:3.11 as builder

WORKDIR /app

COPY ./ /app/

RUN pip install -r requirements.txt
RUN mkdir logs

ENV http_proxy=
ENV https_proxy=

CMD ["python", "-m", "uvicorn", "index:app", "--host", "0.0.0.0", "--port", "80"]
