package ContentParser.Steps


import dagger.Component


@Component(modules = [StepModules::class])
interface ContentParserFactory {
    fun parser() : ContentParserImpl
}

