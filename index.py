from fastapi import FastAPI
from pydantic import BaseModel
app = FastAPI()

class Response(BaseModel):
  response_id: str
  response_data: str
@app.get('/')
def root():
  return Response(response_id='123fd', response_data='gdbdddd')