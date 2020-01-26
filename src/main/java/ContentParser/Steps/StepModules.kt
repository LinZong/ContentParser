package ContentParser.Steps

import ContentParser.SingleInputMultiOutputElementStep
import ContentParser.SingleInputSingleOutputElementStep
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import dagger.multibindings.StringKey

@Module
abstract class StepModules {


    @Binds
    @IntoMap
    @StringKey("getElementById")
    abstract fun getElementById(getElementById: getElementById): SingleInputSingleOutputElementStep


    @Binds
    @IntoMap
    @StringKey("getElementsByClass")
    abstract fun getElementsByClass(getElementsByClass: getElementsByClass): SingleInputMultiOutputElementStep


    @Binds
    @IntoMap
    @StringKey("getElementsByClassSingle")
    abstract fun getElementsByClassSingle(getElementsByClassSingle: getElementsByClassSingle): SingleInputSingleOutputElementStep

    @Binds
    @IntoMap
    @StringKey("getElementsByTag")
    abstract fun getElementsByTag(getElementsByTag: getElementsByTag): SingleInputMultiOutputElementStep


}