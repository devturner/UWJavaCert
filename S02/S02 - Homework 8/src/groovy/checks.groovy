package groovy

// Perform Checkstyle using AntBuilder
def ant = new AntBuilder()
ant.taskdef ( resource : "checkstyletask.properties" , classpath : "/Users/christurner/JAVA/checkstyle-4.4/checkstyle-all-4.4.jar" )
ant.checkstyle (config : "/Users/christurner/JAVA/StudentCheckstylev4.xml") {
	fileset (dir : ".", includes : "**/*.java" )
	formatter( type : "plain", toFile : "checkstyle_errors.txt")
}

// Strip all the directories on the front in the error file
String removeChars = new File(".").getCanonicalPath()
checkstyleFile = new File(removeChars+"/checkstyle_errors.txt")

checkstyleFile.eachLine { line ->
	starting = line.lastIndexOf(removeChars)
	if (starting == 0) {
		line = line.substring(removeChars.length()+1, line.length())
	}
	println line
}