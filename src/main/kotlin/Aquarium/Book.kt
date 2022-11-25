package Aquarium

open class Book (val title: String, val author: String){

    private var currentPage: Int = 0

    open fun readPage(){
        currentPage += 1
    }
}

class EBook(val format: String = "text", title: String, author: String) : Book(title, author) {

    private var wordCount: Int = 0
    override fun readPage() {
        super.readPage()
        wordCount += 250
    }
}