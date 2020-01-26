import ContentParser.Steps.DaggerContentParserFactory

fun main() {
    val parser = DaggerContentParserFactory.create().parser()
    parser.Description()
}