object LetterCounter {
  def countLetterOccurrences(words: List[String]): Int = {
    val lengths = words.map(_.length)

    val totalLetters = lengths.reduce(_ + _)

    totalLetters
  }
}

object TestLetterCounter extends App {
    val words = List("apple", "banana", "cherry", "date")
    val totalCount = LetterCounter.countLetterOccurrences(words)
    println(s"Total count of letter occurrences: $totalCount") 
}

