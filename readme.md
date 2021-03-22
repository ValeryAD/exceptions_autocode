##Description
In this task you need to implement working with exceptions

You need to implement the methods of a client (PlayroomBaseClient.class) which knows how to work with a certain game room. 
The client is able to:

    List<Toy> getAllToys(); - return all toys;

    List<Toy> getToysByParameter(String parameter, String value); - return toys by parameter

	boolean addToy(Toy toy); - adds a toy and returns true if the action is successful

	boolean removeToy(Toy toy); - removes a toy and returns true if the action is successful

	boolean updateToy(Long id, Toy toy); - updates a toy and returns true if the action is successful

In case of an error, each of the methods must return a corresponding exception:
* InitializationException - an exception for the case when it is impossible to initialize the client;
* AddToyException - an exception for the case when it is impossible to add a toy to the current data;
* GetToysByParameterException - an exception for the case when it is impossible to return a toy;
* NoSuchToyException - an exception for the case when it is impossible to find a toy;
* UpdateToyException - an exception for the case when it is impossible to update a toy(e.g. when there is no toy with the required id);
* RemoveToyException - an exception for the case when it is impossible to remove a toy;
