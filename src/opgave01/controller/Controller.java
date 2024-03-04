package opgave01.controller;

import opgave01.models.Person;
import opgave01.models.Role;
import opgave01.storage.EaaaFileStorage;

import java.util.ArrayList;
import java.util.List;

public class Controller {
    EaaaFileStorage eaaaStorage;

    public Controller() {
        this.eaaaStorage = new EaaaFileStorage();
    }

    /**
     *
     * @param role
     * @return List<Person> where all person has the given role
     */
    public List<Person> filter(Role role) {
        List<Person> liste = new ArrayList<>();
        for (Person person : getPeople()) {
            if (person.getRole()==role){
                liste.add(person);
            }
        }
        return liste;
    }

    /**
     *
     * @return all persons
     */
    public List<Person> getPeople() {
        return eaaaStorage.getPeople();
    }

    /**
     * Adds a new person
     * @param person
     */
    public void addPerson(Person person) {
        eaaaStorage.addPerson(person);
    }

    /**
     * Persists all people
     */
    public void save() {
        eaaaStorage.save();
    }
}
