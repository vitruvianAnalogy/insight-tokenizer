echo "Running script"
javac -d ./bin src/Tweet.java src/TweetsFile.java src/Tokenizer.java src/ManagerApp.java
java -cp .:./bin:./src ManagerApp
echo "Check tweet_output folder for checking ft1 and ft2"
