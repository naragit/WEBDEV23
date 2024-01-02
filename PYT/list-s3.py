import boto3
from botocore.exceptions import ClientError

# To get list of buckets present in AWS using S3 client
def get_buckets_client():
   session = boto3.session.Session()
   s3_client = session.client('s3')
   try:
      response = s3_client.list_buckets()
      buckets  =[]
      for bucket in response["Buckets"]:
            v = bucket['Name']
            print("Bucket : "+v)
      print ("\nContents of devnt-s3 bucket ")
      objlist = s3_client.list_objects_v2(Bucket="devnt-s3")
      files = objlist.get("Contents")
      for file in files:
         print(f"file_name: {file['Key']}, size: {file['Size']}")
   except:
      print("An exception occurred")

get_buckets_client()
