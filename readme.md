## Description
In this task you need to implement working with exceptions

You need to implement the methods of a client (PlayroomBaseClient.class) which knows how to work with a certain game room. 
The client is able to:

    List<Toy> getAllToys(); - return all toys;

    List<Toy> getToysByParameter(String parameter, String value); - return toys by parameter

	boolean addToy(Toy toy); - adds a toy and returns true if the action is successful

	boolean removeToy(Toy toy); - removes a toy and returns true if the action is successful

	boolean updateToy(Long id, Toy toy); - updates a toy and returns true if the action is successful

In case of an error, each of the methods must return a corresponding exception:
* InitializationException - an exception for the case when it is impossible to initialize the client. 
  E.g. trying to create client with empty collection or with null.
  
* GetToysByParameterException for List<Toy> getToysByParameter(String parameter, String value); method - 
  an exception for the case when it is impossible to return a toy;
  E.g. trying to find toys for invalid parameters

* AddToyException for boolean addToy(Toy toy); method - an exception for the case when it is impossible to add a toy to the current data.
  E.g. trying to add a toy with an existing id;
  
* UpdateToyException for boolean updateToy(Long id, Toy toy); method - 
  an exception for the case when it is impossible to update a toy.
  E.g. trying to find toy with absent id;
  
* RemoveToyException for boolean removeToy(Toy toy) - 
  an exception for the case when it is impossible to remove a toy.
  E.g. trying to remove toy with absent id;

boolean addToy(Toy toy);, boolean updateToy(Long id, Toy toy); and boolean removeToy(Toy toy)
have to return false if we can't perform action due to invalid toy.
Valid toy - a toy with a unique identifier and all fields filled in.
