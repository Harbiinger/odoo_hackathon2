package officeOlympics.backend;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;


public class Game {
    public static HashMap<String, Person> people;

    public Game(String filePath) {
        people = new HashMap<>();
        try {
            String path = System.getProperty("user.dir") + "/app/src/main/resources/back/jo.json";
            String json = new String(Files.readAllBytes(Paths.get(path)));

            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode rootNode = objectMapper.readTree(json);

            ArrayNode peopleArray = (ArrayNode) rootNode.get("people");

            for (JsonNode personNode : peopleArray) {
                String lastName = personNode.get("lastName").asText();
                String firstName = personNode.get("firstName").asText();
                String profession = personNode.get("profession").asText();
                String nationality = personNode.get("nationality").asText();

                ArrayList<Interaction> interactions = new ArrayList<>();

                ArrayNode interactionsArray = (ArrayNode) personNode.get("interactions");
                for (JsonNode interactionNode : interactionsArray) {
                    int interactionId = interactionNode.get("id").asInt();
                    String interactionText = interactionNode.get("text").asText();

                    ArrayList<Choice> choices = new ArrayList<>();

                    ArrayNode choicesArray = (ArrayNode) interactionNode.get("choices");
                    for (JsonNode choiceNode : choicesArray) {
                        int choiceId = choiceNode.get("id").asInt();
                        int interactionDir = choiceNode.get("interactionDir").asInt();
                        boolean isLocked = choiceNode.get("isLocked").asBoolean();
                        String value = choiceNode.get("value").asText();

                        choices.add(new Choice(choiceId, interactionDir, isLocked, value, null));
                    }

                    interactions.add(new Interaction(interactionId, choices, interactionText));
                }

                Person person = new Person(lastName, firstName, profession,interactions);
                people.put(person.getLastName(), person);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        }

    /**
     * The player talks to a person a load the action to the game
     * @param personName The id of the person
     * @return The person
     */
    public Person talk(String personName) {
        return people.get(personName);
    }

    /**
     * Get the list of all persons to setup the game with the GUI
     */
    public ArrayList<Person> getPersons() {
        return new ArrayList<>(people.values());
    }
}
