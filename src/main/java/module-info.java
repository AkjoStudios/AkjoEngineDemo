@SuppressWarnings("Java9RedundantRequiresStatement")
module AkjoEngineDemo {
    requires org.jetbrains.annotations;
    requires lombok;
    requires AkjoEngineApi;

    exports com.akjostudios.engine.demo;
}