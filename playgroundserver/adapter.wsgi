import os,sys

dirpath = os.path.dirname(os.path.abspath(__file__))
sys.path.append(dirpath)
os.chdir(dirpath)
import server

application = server.app
