import java.security.MessageDigest

def md5(s: String) = {
    MessageDigest.getInstance("MD5").digest(s.getBytes)
}

println("Hash for 'Hello'")

var hashAoB = md5("Hello")

var hashAoC = new Array[Char](16)

val niceAoC = "ABCDEFGHJKLMNPQRSTUVWXYZ23456789"

println()

var myInt : Int = 0
var c : Char = ' '

def makeNiceStr(AoB : Array[Byte]) : String = 
{
   var AoC = new Array[Char](AoB.length)
   
   for (i <- 0 to AoB.length - 1)
   {
   // AoB(i) = AoB(i) & 31
   // workaround for Scala bug
      myInt = AoB(i)
      myInt = myInt & 31
      c = niceAoC.charAt(myInt)
	  AoC(i) = c
   }
   return(AoC.mkString(""))
}

makeNiceStr(hashAoB)
   
// hash a bunch of names

println("Delaware Pennsylvania California Texas...")
println(makeNiceStr(md5("Delaware Pennsylvania California Texas...")))

println("Ecuador Japan Bhutan Paraguay")
println(makeNiceStr(md5("Ecuador Japan Bhutan Paraguay")))

println("Russia Romania")
println(makeNiceStr(md5("Russia Romania")))

println("Turkmenistan Denmark")
println(makeNiceStr(md5("Turkmenistan Denmark")))

println("Tajikistan Jamaica")
println(makeNiceStr(md5("Tajikistan Jamaica")))

println("Panama Djibouti Nepal")
println(makeNiceStr(md5("Panama Djibouti Nepal")))

println("Bolivia Srilanka Singapore")
println(makeNiceStr(md5("Bolivia Srilanka Singapore")))


// Generate an array of random Bytes

import java.io.PrintWriter
val fileHandle = new PrintWriter("arrs.dat")

var rb = new Array[Byte](30)
var rblen : Int = 0  // length of the random string

for (i <- 0 to 9999)
{
  for (j <- 0 to 1)
  {
         scala.util.Random.nextBytes(rb)
	 rblen = scala.util.Random.nextInt(20)
	 fileHandle.print(makeNiceStr(rb).take(10+rblen))
	 fileHandle.print(" , ")
  }
  scala.util.Random.nextBytes(rb)
  rblen = scala.util.Random.nextInt(20)
  fileHandle.println(makeNiceStr(rb).take(10+rblen))  
}

fileHandle.close()

println();println("wrote arrs.dat"); println()
