package se.nrm.bas.specify.solr.service.logic.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.StringReader; 
import java.util.List;  
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader; 
import lombok.extern.slf4j.Slf4j;
import se.nrm.bas.specify.gbif.datamodel.SimpleDwc;

/**
 *
 * @author idali
 */
@Slf4j
public class JsonConverter {

  private JsonReader jsonReader;

  private final String response = "response";
  private final String numFound = "numFound";
  private final String docs = "docs"; 
  
  private JsonArray array;

  private static JsonConverter instance = null;

  public static JsonConverter getInstance() {
    synchronized (JsonConverter.class) {
      if (instance == null) {
        instance = new JsonConverter();
      }
    }
    return instance;
  }

  public JsonObject buildResponseJson(String jsonString) {
    jsonReader = Json.createReader(new StringReader(jsonString));
    return jsonReader.readObject().getJsonObject(response);
  }

  public int getTotalNumberFound(JsonObject json) {
    return json.getInt(numFound);
  }

  public JsonArray getSolrDocs(JsonObject json) {
    return json.getJsonArray(docs);
  }

  public List<SimpleDwc> mapEntities(JsonObject json) {
    array = json.getJsonArray(docs); 
    try { 
      ObjectMapper objectMapper = new ObjectMapper();
      objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
      return objectMapper.readValue(array.toString(), new TypeReference<List<SimpleDwc>>(){}); 
    } catch (JsonProcessingException ex) { 
      log.error(ex.getMessage());
    }
    return null;
  }
}
