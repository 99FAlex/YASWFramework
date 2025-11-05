# YASWFramework
A RESTful API Framework




To initiate Restful Server:
YaswHttpServer.init(port);




Add Mapping by using:
YaswHttpServer.server.createContext("/ExampleMapping", new MyHandler);




Start/Stop Server:
YaswHttpServer.server.start();
YaswHttpServer.server.stop();


