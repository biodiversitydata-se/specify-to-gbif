package se.nrm.bas.specify.gbif.datamodel;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity; 
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
//import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author idali
 */
@Entity
@Table(name = "simpleDwc")
@XmlRootElement
@NamedQueries({
  @NamedQuery(name = "SimpleDwc.findAll", query = "SELECT s FROM SimpleDwc s"),
  @NamedQuery(name = "SimpleDwc.findById", query = "SELECT s FROM SimpleDwc s WHERE s.id = :id"),
  @NamedQuery(name = "SimpleDwc.findByModified", query = "SELECT s FROM SimpleDwc s WHERE s.modified = :modified"), 
  @NamedQuery(name = "SimpleDwc.findByGuid", query = "SELECT s FROM SimpleDwc s WHERE s.guid = :guid")})
public class SimpleDwc implements Serializable {

  private static final long serialVersionUID = 1L;
  
  @Id
//  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Basic(optional = false)
  @Column(name = "id")
  private String id;
   
  @Size(max = 45)
  @Column(name = "type")
  private String type;
  
  @Column(name = "modified")
  @Temporal(TemporalType.TIMESTAMP)
  private Date modified; 
  
  @Size(max = 45)
  @Column(name = "language")
  private String language;
  
  @Lob
  @Size(max = 65535)
  @Column(name = "license")
  private String license;
   
  @Size(max = 45)
  @Column(name = "rightsHolder")
  private String rightsHolder;
  
  @Lob
  @Size(max = 65535)
  @Column(name = "accessRights")
  private String accessRights; 
  
  @Size(max = 45)
  @Column(name = "bibliographicCitation")
  private String bibliographicCitation;
  
  @Size(max = 45)
  @Column(name = "references")
  private String references;
  
  @Size(max = 128)
  @Column(name = "institutionID")
  private String institutionID;
  
  @Size(max = 45)
  @Column(name = "collectionID")
  private String collectionID;
  
  @Size(max = 45)
  @Column(name = "datasetID")
  private String datasetID;
  
  @Size(max = 64)
  @Column(name = "institutionCode")
  private String institutionCode;
  
  @Size(max = 50)
  @Column(name = "collectionCode")
  private String collectionCode;
   
  @Lob
  @Size(max = 65535)
  @Column(name = "datasetName")
  private String datasetName;
  
  @Size(max = 45)
  @Column(name = "ownerInstitutionCode")
  private String ownerInstitutionCode;
  
  @Size(max = 32)
  @Column(name = "basisOfRecord")
  private String basisOfRecord;
  
  @Size(max = 45)
  @Column(name = "informationWithheld")
  private String informationWithheld;
  
  @Size(max = 45)
  @Column(name = "dataGeneralizations")
  private String dataGeneralizations; 
   
  @Size(max = 45)
  @Column(name = "dynamicProperties")
  private String dynamicProperties;
   
  @Size(max = 45)
  @Column(name = "occurrenceID")
  private String occurrenceID;
   
  @Size(max = 32)
  @Column(name = "catalogNumber")
  private String catalogNumber;
   
  @Size(max = 45)
  @Column(name = "recordNumber")
  private String recordNumber;
  
  @Size(max = 255)
  @Column(name = "recordedBy")
  private String recordedBy;
  
  @Column(name = "individualCount")
  private Integer individualCount;
  
  @Size(max = 45)
  @Column(name = "organismQuantity")
  private String organismQuantity;
   
  @Size(max = 45)
  @Column(name = "organismQuantityType")
  private String organismQuantityType;
   
  @Lob
  @Size(max = 65535)
  @Column(name = "sex")
  private String sex;
  
  @Size(max = 50)
  @Column(name = "lifeStage")
  private String lifeStage;
  
  @Size(max = 45)
  @Column(name = "reproductiveCondition")
  private String reproductiveCondition;
  
  @Size(max = 45)
  @Column(name = "behavior")
  private String behavior;
  
  @Size(max = 45)
  @Column(name = "establishmentMeans")
  private String establishmentMeans;
   
  @Size(max = 45)
  @Column(name = "occurrenceStatus")
  private String occurrenceStatus;
  
  @Size(max = 128)
  @Column(name = "preparations")
  private String preparations;
  
  @Size(max = 45)
  @Column(name = "disposition")
  private String disposition;
  
  @Size(max = 45)
  @Column(name = "associatedMedia")
  private String associatedMedia;
  
  @Size(max = 45)
  @Column(name = "associatedReferences")
  private String associatedReferences;
  
  @Size(max = 45)
  @Column(name = "associatedSequences")
  private String associatedSequences;
  
  @Size(max = 45)
  @Column(name = "associatedTaxa")
  private String associatedTaxa;
  
  @Size(max = 64)
  @Column(name = "otherCatalogNumbers")
  private String otherCatalogNumbers;
   
  @Lob
  @Size(max = 65535)
  @Column(name = "occurrenceRemarks")
  private String occurrenceRemarks;
  
  @Size(max = 45)
  @Column(name = "organismID")
  private String organismID;
  
  @Size(max = 45)
  @Column(name = "organismName")
  private String organismName;
  
  @Size(max = 45)
  @Column(name = "organismScope")
  private String organismScope;
  
  @Size(max = 45)
  @Column(name = "associatedOccurrences")
  private String associatedOccurrences;
  
  @Size(max = 45)
  @Column(name = "associatedOrganisms")
  private String associatedOrganisms;
   
  @Size(max = 45)
  @Column(name = "previousIdentifications")
  private String previousIdentifications;
   
  @Lob
  @Size(max = 65535)
  @Column(name = "organismRemarks")
  private String organismRemarks;
  
  @Size(max = 45)
  @Column(name = "materialSampleID")
  private String materialSampleID;
  
  @Size(max = 45)
  @Column(name = "eventID")
  private String eventID;
  
  @Size(max = 45)
  @Column(name = "parentEventID")
  private String parentEventID;
  
  @Size(max = 50)
  @Column(name = "fieldNumber")
  private String fieldNumber;
  
  @Column(name = "eventDate")
  @Temporal(TemporalType.DATE)
  private Date eventDate;
  
  @Column(name = "eventTime")
  private Short eventTime;
  
  @Size(max = 45)
  @Column(name = "startDayOfYear")
  private String startDayOfYear;
  
  @Size(max = 45)
  @Column(name = "endDayOfYear")
  private String endDayOfYear;
  
  @Column(name = "year")
  private Integer year;
   
  @Column(name = "month")
  private Integer month;
  
  @Column(name = "day")
  private Integer day;
  
  @Size(max = 50)
  @Column(name = "verbatimEventDate")
  private String verbatimEventDate;
  
  @Lob
  @Size(max = 65535)
  @Column(name = "eventRemarks")
  private String eventRemarks;
  
  @Size(max = 50)
  @Column(name = "habitat")
  private String habitat;
  
  @Size(max = 45)
  @Column(name = "samplingProtocol")
  private String samplingProtocol;
  
  @Size(max = 45)
  @Column(name = "sampleSizeValue")
  private String sampleSizeValue;
  
  @Size(max = 45)
  @Column(name = "sampleSizeUnit")
  private String sampleSizeUnit;
  
  @Size(max = 45)
  @Column(name = "samplingEffort")
  private String samplingEffort;
  
  @Size(max = 128)
  @Column(name = "fieldNotes")
  private String fieldNotes;
  
  @Size(max = 45)
  @Column(name = "locationID")
  private String locationID;
  
  @Size(max = 45)
  @Column(name = "higherGeographyID")
  private String higherGeographyID;
  
  @Size(max = 255)
  @Column(name = "higherGeography")
  private String higherGeography;
  
  @Size(max = 64)
  @Column(name = "continent")
  private String continent;
  
  @Size(max = 64)
  @Column(name = "waterBody")
  private String waterBody;
  
  @Size(max = 64)
  @Column(name = "islandGroup")
  private String islandGroup;
  
  @Size(max = 64)
  @Column(name = "island")
  private String island;
  
  @Size(max = 64)
  @Column(name = "country")
  private String country;
  
  @Size(max = 45)
  @Column(name = "countryCode")
  private String countryCode;
  
  @Size(max = 64)
  @Column(name = "stateProvince")
  private String stateProvince;
  
  @Size(max = 64)
  @Column(name = "county")
  private String county;
  
  @Size(max = 45)
  @Column(name = "municipality")
  private String municipality;
  
  @Size(max = 255)
  @Column(name = "locality")
  private String locality;
  
  @Lob
  @Size(max = 65535)
  @Column(name = "verbatimLocality")
  private String verbatimLocality;
   
  // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
  @Column(name = "minimumElevationInMeters")
  private Double minimumElevationInMeters;
  
  @Column(name = "maximumElevationInMeters")
  private Double maximumElevationInMeters;
  
  @Size(max = 50)
  @Column(name = "verbatimElevation")
  private String verbatimElevation;
  
  @Lob
  @Size(max = 65535)
  @Column(name = "minimumDepthInMeters")
  private String minimumDepthInMeters;
   
  @Lob
  @Size(max = 65535)
  @Column(name = "maximumDepthInMeters")
  private String maximumDepthInMeters;
  
  @Size(max = 45)
  @Column(name = "verbatimDepth")
  private String verbatimDepth;
  
  @Size(max = 45)
  @Column(name = "minimumDistanceAboveSurfaceInMeters")
  private String minimumDistanceAboveSurfaceInMeters;
   
  @Size(max = 45)
  @Column(name = "maximumDistanceAboveSurfaceInMeters")
  private String maximumDistanceAboveSurfaceInMeters;
   
  @Size(max = 45)
  @Column(name = "locationAccordingTo")
  private String locationAccordingTo;
  
  @Lob
  @Size(max = 65535)
  @Column(name = "locationRemarks")
  private String locationRemarks;
   
  @Column(name = "decimalLatitude")
  private BigDecimal decimalLatitude;
  
  @Column(name = "decimalLongitude")  
  private BigDecimal decimalLongitude;
  
  @Size(max = 50)
  @Column(name = "geodeticDatum")
  private String geodeticDatum;
  
  @Column(name = "coordinateUncertaintyInMeters")
  private Double coordinateUncertaintyInMeters;
   
  @Size(max = 45)
  @Column(name = "coordinatePrecision")
  private String coordinatePrecision;
   
  @Size(max = 45)
  @Column(name = "pointRadiusSpatialFit")
  private String pointRadiusSpatialFit;
  
  @Size(max = 64)
  @Column(name = "verbatimCoordinates")
  private String verbatimCoordinates;
  
  @Size(max = 64)
  @Column(name = "verbatimLatitude")
  private String verbatimLatitude;
  
  @Size(max = 64)
  @Column(name = "verbatimLongitude")
  private String verbatimLongitude;
  
  @Size(max = 45)
  @Column(name = "verbatimCoordinateSystem")
  private String verbatimCoordinateSystem;
  
  @Size(max = 45)
  @Column(name = "verbatimSRS")
  private String verbatimSRS;
  
  @Size(max = 45)
  @Column(name = "footprintWKT")
  private String footprintWKT;
   
  @Size(max = 45)
  @Column(name = "footprintSRS")
  private String footprintSRS;
  
  @Size(max = 45)
  @Column(name = "footprintSpatialFit")
  private String footprintSpatialFit;
  
  @Size(max = 255)
  @Column(name = "georeferencedBy")
  private String georeferencedBy;
  
  @Column(name = "georeferencedDate")
  @Temporal(TemporalType.TIMESTAMP)
  private Date georeferencedDate;
  
  @Size(max = 64)
  @Column(name = "georeferenceProtocol")
  private String georeferenceProtocol;
  
  @Size(max = 64)
  @Column(name = "georeferenceSources")
  private String georeferenceSources;
   
  @Size(max = 50)
  @Column(name = "georeferenceVerificationStatus")
  private String georeferenceVerificationStatus;
  
  @Lob
  @Size(max = 65535)
  @Column(name = "georeferenceRemarks")
  private String georeferenceRemarks;
  
  @Size(max = 45)
  @Column(name = "geologicalContextID")
  private String geologicalContextID;
  
  @Size(max = 45)
  @Column(name = "earliestEonOrLowestEonothem")
  private String earliestEonOrLowestEonothem;
  
  @Size(max = 45)
  @Column(name = "latestEonOrHighestEonothem")
  private String latestEonOrHighestEonothem;
  
  @Size(max = 45)
  @Column(name = "earliestEraOrLowestErathem")
  private String earliestEraOrLowestErathem;
  
  @Size(max = 45)
  @Column(name = "latestEraOrHighestErathem")
  private String latestEraOrHighestErathem;
   
  @Size(max = 45)
  @Column(name = "earliestPeriodOrLowestSystem")
  private String earliestPeriodOrLowestSystem;
  
  @Size(max = 45)
  @Column(name = "latestPeriodOrHighestSystem")
  private String latestPeriodOrHighestSystem;
  
  @Size(max = 45)
  @Column(name = "earliestEpochOrLowestSeries")
  private String earliestEpochOrLowestSeries;
  
  @Size(max = 45)
  @Column(name = "latestEpochOrHighestSeries")
  private String latestEpochOrHighestSeries;
   
  @Size(max = 45)
  @Column(name = "earliestAgeOrLowestStage")
  private String earliestAgeOrLowestStage;
  
  @Size(max = 45)
  @Column(name = "latestAgeOrHighestStage")
  private String latestAgeOrHighestStage;
  
  @Size(max = 45)
  @Column(name = "lowestBiostratigraphicZone")
  private String lowestBiostratigraphicZone;
  
  @Size(max = 45)
  @Column(name = "highestBiostratigraphicZone")
  private String highestBiostratigraphicZone;
  
  @Size(max = 45)
  @Column(name = "lithostratigraphicTerms")
  private String lithostratigraphicTerms;
   
  @Size(max = 45)
  @Column(name = "group")
  private String group;
  
  @Size(max = 45)
  @Column(name = "formation")
  private String formation;
   
  @Size(max = 45)
  @Column(name = "member")
  private String member;
  
  @Size(max = 45)
  @Column(name = "bed")
  private String bed;
  
  @Size(max = 45)
  @Column(name = "identificationID")
  private String identificationID;
  
  @Size(max = 16)
  @Column(name = "identificationQualifier")
  private String identificationQualifier;
  
  @Size(max = 50)
  @Column(name = "typeStatus")
  private String typeStatus;
  
  @Size(max = 225)
  @Column(name = "identifiedBy")
  private String identifiedBy;
   
  @Column(name = "dateIdentified")
  @Temporal(TemporalType.DATE)
  private Date dateIdentified;
  
  @Size(max = 45)
  @Column(name = "identificationReferences")
  private String identificationReferences;
  
  @Size(max = 45)
  @Column(name = "identificationVerificationStatus")
  private String identificationVerificationStatus;
  
  @Lob
  @Size(max = 65535)
  @Column(name = "identificationRemarks")
  private String identificationRemarks;
  
  @Size(max = 45)
  @Column(name = "taxonID")
  private String taxonID;
  
  @Size(max = 45)
  @Column(name = "scientificNameID")
  private String scientificNameID;
  
  @Size(max = 45)
  @Column(name = "acceptedNameUsageID")
  private String acceptedNameUsageID;
  
  @Size(max = 45)
  @Column(name = "parentNameUsageID")
  private String parentNameUsageID; 
  
  @Size(max = 45)
  @Column(name = "originalNameUsageID")
  private String originalNameUsageID;
  
  @Size(max = 45)
  @Column(name = "nameAccordingToID")
  private String nameAccordingToID;
  
  @Size(max = 45)
  @Column(name = "namePublishedInID")
  private String namePublishedInID;
   
  @Size(max = 45)
  @Column(name = "taxonConceptID")
  private String taxonConceptID;
   
  @Size(max = 255)
  @Column(name = "scientificName")
  private String scientificName;
  
  @Size(max = 45)
  @Column(name = "acceptedNameUsage")
  private String acceptedNameUsage;
  
  @Size(max = 45)
  @Column(name = "parentNameUsage")
  private String parentNameUsage;
  
  @Size(max = 45)
  @Column(name = "originalNameUsage")
  private String originalNameUsage;
  
  @Size(max = 45)
  @Column(name = "nameAccordingTo")
  private String nameAccordingTo;
   
  @Size(max = 45)
  @Column(name = "namePublishedIn")
  private String namePublishedIn;
  
  @Size(max = 45)
  @Column(name = "namePublishedInYear")
  private String namePublishedInYear;
  
  @Size(max = 45)
  @Column(name = "higherClassification")
  private String higherClassification;
  
  @Size(max = 255)
  @Column(name = "kingdom")
  private String kingdom;
  
  @Size(max = 255)
  @Column(name = "phylum")
  private String phylum;
  
  @Size(max = 255)
  @Column(name = "class")
  private String clazz;
  
  @Size(max = 255)
  @Column(name = "order")
  private String order;
   
  @Size(max = 255)
  @Column(name = "family")
  private String family;
   
  @Size(max = 255)
  @Column(name = "genus")
  private String genus;
   
  @Size(max = 255)
  @Column(name = "subgenus")
  private String subgenus;
  
  @Size(max = 255)
  @Column(name = "specificEpithet")
  private String specificEpithet;
  
  @Size(max = 255)
  @Column(name = "infraspecificEpithet")
  private String infraspecificEpithet;
  
  @Size(max = 45)
  @Column(name = "taxonRank")
  private String taxonRank;
  
  @Size(max = 45)
  @Column(name = "verbatimTaxonRank")
  private String verbatimTaxonRank;
  
  @Size(max = 255)
  @Column(name = "scientificNameAuthorship")
  private String scientificNameAuthorship;
  
  @Lob
  @Size(max = 65535)
  @Column(name = "vernacularName")
  private String vernacularName;
  
  @Size(max = 45)
  @Column(name = "nomenclaturalCode")
  private String nomenclaturalCode;
  
  @Size(max = 45)
  @Column(name = "taxonomicStatus")
  private String taxonomicStatus;
  
  @Size(max = 45)
  @Column(name = "nomenclaturalStatus")
  private String nomenclaturalStatus;
  
  @Lob
  @Size(max = 65535)
  @Column(name = "taxonRemarks")
  private String taxonRemarks;
  
//  @Basic(optional = false)
//  @NotNull
  @Size(min = 1, max = 128)
  @Column(name = "guid")
  private String guid;

  public SimpleDwc() {
  }

  public SimpleDwc(String id) {
    this.id = id;
  }

  public SimpleDwc(String id, String guid) {
    this.id = id;
    this.guid = guid;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public Date getModified() {
    return modified;
  }

  public void setModified(Date modified) {
    this.modified = modified;
  }

  public String getLanguage() {
    return language;
  }

  public void setLanguage(String language) {
    this.language = language;
  }

  public String getLicense() {
    return license;
  }

  public void setLicense(String license) {
    this.license = license;
  }

  public String getRightsHolder() {
    return rightsHolder;
  }

  public void setRightsHolder(String rightsHolder) {
    this.rightsHolder = rightsHolder;
  }

  public String getAccessRights() {
    return accessRights;
  }

  public void setAccessRights(String accessRights) {
    this.accessRights = accessRights;
  }

  public String getBibliographicCitation() {
    return bibliographicCitation;
  }

  public void setBibliographicCitation(String bibliographicCitation) {
    this.bibliographicCitation = bibliographicCitation;
  }

  public String getReferences() {
    return references;
  }

  public void setReferences(String references) {
    this.references = references;
  }

  public String getInstitutionID() {
    return institutionID;
  }

  public void setInstitutionID(String institutionID) {
    this.institutionID = institutionID;
  }

  public String getCollectionID() {
    return collectionID;
  }

  public void setCollectionID(String collectionID) {
    this.collectionID = collectionID;
  }

  public String getDatasetID() {
    return datasetID;
  }

  public void setDatasetID(String datasetID) {
    this.datasetID = datasetID;
  }

  public String getInstitutionCode() {
    return institutionCode;
  }

  public void setInstitutionCode(String institutionCode) {
    this.institutionCode = institutionCode;
  }

  public String getCollectionCode() {
    return collectionCode;
  }

  public void setCollectionCode(String collectionCode) {
    this.collectionCode = collectionCode;
  }

  public String getDatasetName() {
    return datasetName;
  }

  public void setDatasetName(String datasetName) {
    this.datasetName = datasetName;
  }

  public String getOwnerInstitutionCode() {
    return ownerInstitutionCode;
  }

  public void setOwnerInstitutionCode(String ownerInstitutionCode) {
    this.ownerInstitutionCode = ownerInstitutionCode;
  }

  public String getBasisOfRecord() {
    return basisOfRecord;
  }

  public void setBasisOfRecord(String basisOfRecord) {
    this.basisOfRecord = basisOfRecord;
  }

  public String getInformationWithheld() {
    return informationWithheld;
  }

  public void setInformationWithheld(String informationWithheld) {
    this.informationWithheld = informationWithheld;
  }

  public String getDataGeneralizations() {
    return dataGeneralizations;
  }

  public void setDataGeneralizations(String dataGeneralizations) {
    this.dataGeneralizations = dataGeneralizations;
  }

  public String getDynamicProperties() {
    return dynamicProperties;
  }

  public void setDynamicProperties(String dynamicProperties) {
    this.dynamicProperties = dynamicProperties;
  }

  public String getOccurrenceID() {
    return occurrenceID;
  }

  public void setOccurrenceID(String occurrenceID) {
    this.occurrenceID = occurrenceID;
  }

  public String getCatalogNumber() {
    return catalogNumber;
  }

  public void setCatalogNumber(String catalogNumber) {
    this.catalogNumber = catalogNumber;
  }

  public String getRecordNumber() {
    return recordNumber;
  }

  public void setRecordNumber(String recordNumber) {
    this.recordNumber = recordNumber;
  }

  public String getRecordedBy() {
    return recordedBy;
  }

  public void setRecordedBy(String recordedBy) {
    this.recordedBy = recordedBy;
  }

  public Integer getIndividualCount() {
    return individualCount;
  }

  public void setIndividualCount(Integer individualCount) {
    this.individualCount = individualCount;
  }

  public String getOrganismQuantity() {
    return organismQuantity;
  }

  public void setOrganismQuantity(String organismQuantity) {
    this.organismQuantity = organismQuantity;
  }

  public String getOrganismQuantityType() {
    return organismQuantityType;
  }

  public void setOrganismQuantityType(String organismQuantityType) {
    this.organismQuantityType = organismQuantityType;
  }

  public String getSex() {
    return sex;
  }

  public void setSex(String sex) {
    this.sex = sex;
  }

  public String getLifeStage() {
    return lifeStage;
  }

  public void setLifeStage(String lifeStage) {
    this.lifeStage = lifeStage;
  }

  public String getReproductiveCondition() {
    return reproductiveCondition;
  }

  public void setReproductiveCondition(String reproductiveCondition) {
    this.reproductiveCondition = reproductiveCondition;
  }

  public String getBehavior() {
    return behavior;
  }

  public void setBehavior(String behavior) {
    this.behavior = behavior;
  }

  public String getEstablishmentMeans() {
    return establishmentMeans;
  }

  public void setEstablishmentMeans(String establishmentMeans) {
    this.establishmentMeans = establishmentMeans;
  }

  public String getOccurrenceStatus() {
    return occurrenceStatus;
  }

  public void setOccurrenceStatus(String occurrenceStatus) {
    this.occurrenceStatus = occurrenceStatus;
  }

  public String getPreparations() {
    return preparations;
  }

  public void setPreparations(String preparations) {
    this.preparations = preparations;
  }

  public String getDisposition() {
    return disposition;
  }

  public void setDisposition(String disposition) {
    this.disposition = disposition;
  }

  public String getAssociatedMedia() {
    return associatedMedia;
  }

  public void setAssociatedMedia(String associatedMedia) {
    this.associatedMedia = associatedMedia;
  }

  public String getAssociatedReferences() {
    return associatedReferences;
  }

  public void setAssociatedReferences(String associatedReferences) {
    this.associatedReferences = associatedReferences;
  }

  public String getAssociatedSequences() {
    return associatedSequences;
  }

  public void setAssociatedSequences(String associatedSequences) {
    this.associatedSequences = associatedSequences;
  }

  public String getAssociatedTaxa() {
    return associatedTaxa;
  }

  public void setAssociatedTaxa(String associatedTaxa) {
    this.associatedTaxa = associatedTaxa;
  }

  public String getOtherCatalogNumbers() {
    return otherCatalogNumbers;
  }

  public void setOtherCatalogNumbers(String otherCatalogNumbers) {
    this.otherCatalogNumbers = otherCatalogNumbers;
  }

  public String getOccurrenceRemarks() {
    return occurrenceRemarks;
  }

  public void setOccurrenceRemarks(String occurrenceRemarks) {
    this.occurrenceRemarks = occurrenceRemarks;
  }

  public String getOrganismID() {
    return organismID;
  }

  public void setOrganismID(String organismID) {
    this.organismID = organismID;
  }

  public String getOrganismName() {
    return organismName;
  }

  public void setOrganismName(String organismName) {
    this.organismName = organismName;
  }

  public String getOrganismScope() {
    return organismScope;
  }

  public void setOrganismScope(String organismScope) {
    this.organismScope = organismScope;
  }

  public String getAssociatedOccurrences() {
    return associatedOccurrences;
  }

  public void setAssociatedOccurrences(String associatedOccurrences) {
    this.associatedOccurrences = associatedOccurrences;
  }

  public String getAssociatedOrganisms() {
    return associatedOrganisms;
  }

  public void setAssociatedOrganisms(String associatedOrganisms) {
    this.associatedOrganisms = associatedOrganisms;
  }

  public String getPreviousIdentifications() {
    return previousIdentifications;
  }

  public void setPreviousIdentifications(String previousIdentifications) {
    this.previousIdentifications = previousIdentifications;
  }

  public String getOrganismRemarks() {
    return organismRemarks;
  }

  public void setOrganismRemarks(String organismRemarks) {
    this.organismRemarks = organismRemarks;
  }

  public String getMaterialSampleID() {
    return materialSampleID;
  }

  public void setMaterialSampleID(String materialSampleID) {
    this.materialSampleID = materialSampleID;
  }

  public String getEventID() {
    return eventID;
  }

  public void setEventID(String eventID) {
    this.eventID = eventID;
  }

  public String getParentEventID() {
    return parentEventID;
  }

  public void setParentEventID(String parentEventID) {
    this.parentEventID = parentEventID;
  }

  public String getFieldNumber() {
    return fieldNumber;
  }

  public void setFieldNumber(String fieldNumber) {
    this.fieldNumber = fieldNumber;
  }

  public Date getEventDate() {
    return eventDate;
  }

  public void setEventDate(Date eventDate) {
    this.eventDate = eventDate;
  }

  public Short getEventTime() {
    return eventTime;
  }

  public void setEventTime(Short eventTime) {
    this.eventTime = eventTime;
  }

  public String getStartDayOfYear() {
    return startDayOfYear;
  }

  public void setStartDayOfYear(String startDayOfYear) {
    this.startDayOfYear = startDayOfYear;
  }

  public String getEndDayOfYear() {
    return endDayOfYear;
  }

  public void setEndDayOfYear(String endDayOfYear) {
    this.endDayOfYear = endDayOfYear;
  }

  public Integer getYear() {
    return year;
  }

  public void setYear(Integer year) {
    this.year = year;
  }

  public Integer getMonth() {
    return month;
  }

  public void setMonth(Integer month) {
    this.month = month;
  }

  public Integer getDay() {
    return day;
  }

  public void setDay(Integer day) {
    this.day = day;
  }

  public String getVerbatimEventDate() {
    return verbatimEventDate;
  }

  public void setVerbatimEventDate(String verbatimEventDate) {
    this.verbatimEventDate = verbatimEventDate;
  }

  public String getEventRemarks() {
    return eventRemarks;
  }

  public void setEventRemarks(String eventRemarks) {
    this.eventRemarks = eventRemarks;
  }

  public String getHabitat() {
    return habitat;
  }

  public void setHabitat(String habitat) {
    this.habitat = habitat;
  }

  public String getSamplingProtocol() {
    return samplingProtocol;
  }

  public void setSamplingProtocol(String samplingProtocol) {
    this.samplingProtocol = samplingProtocol;
  }

  public String getSampleSizeValue() {
    return sampleSizeValue;
  }

  public void setSampleSizeValue(String sampleSizeValue) {
    this.sampleSizeValue = sampleSizeValue;
  }

  public String getSampleSizeUnit() {
    return sampleSizeUnit;
  }

  public void setSampleSizeUnit(String sampleSizeUnit) {
    this.sampleSizeUnit = sampleSizeUnit;
  }

  public String getSamplingEffort() {
    return samplingEffort;
  }

  public void setSamplingEffort(String samplingEffort) {
    this.samplingEffort = samplingEffort;
  }

  public String getFieldNotes() {
    return fieldNotes;
  }

  public void setFieldNotes(String fieldNotes) {
    this.fieldNotes = fieldNotes;
  }

  public String getLocationID() {
    return locationID;
  }

  public void setLocationID(String locationID) {
    this.locationID = locationID;
  }

  public String getHigherGeographyID() {
    return higherGeographyID;
  }

  public void setHigherGeographyID(String higherGeographyID) {
    this.higherGeographyID = higherGeographyID;
  }

  public String getHigherGeography() {
    return higherGeography;
  }

  public void setHigherGeography(String higherGeography) {
    this.higherGeography = higherGeography;
  }

  public String getContinent() {
    return continent;
  }

  public void setContinent(String continent) {
    this.continent = continent;
  }

  public String getWaterBody() {
    return waterBody;
  }

  public void setWaterBody(String waterBody) {
    this.waterBody = waterBody;
  }

  public String getIslandGroup() {
    return islandGroup;
  }

  public void setIslandGroup(String islandGroup) {
    this.islandGroup = islandGroup;
  }

  public String getIsland() {
    return island;
  }

  public void setIsland(String island) {
    this.island = island;
  }

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public String getCountryCode() {
    return countryCode;
  }

  public void setCountryCode(String countryCode) {
    this.countryCode = countryCode;
  }

  public String getStateProvince() {
    return stateProvince;
  }

  public void setStateProvince(String stateProvince) {
    this.stateProvince = stateProvince;
  }

  public String getCounty() {
    return county;
  }

  public void setCounty(String county) {
    this.county = county;
  }

  public String getMunicipality() {
    return municipality;
  }

  public void setMunicipality(String municipality) {
    this.municipality = municipality;
  }

  public String getLocality() {
    return locality;
  }

  public void setLocality(String locality) {
    this.locality = locality;
  }

  public String getVerbatimLocality() {
    return verbatimLocality;
  }

  public void setVerbatimLocality(String verbatimLocality) {
    this.verbatimLocality = verbatimLocality;
  }

  public Double getMinimumElevationInMeters() {
    return minimumElevationInMeters;
  }

  public void setMinimumElevationInMeters(Double minimumElevationInMeters) {
    this.minimumElevationInMeters = minimumElevationInMeters;
  }

  public Double getMaximumElevationInMeters() {
    return maximumElevationInMeters;
  }

  public void setMaximumElevationInMeters(Double maximumElevationInMeters) {
    this.maximumElevationInMeters = maximumElevationInMeters;
  }

  public String getVerbatimElevation() {
    return verbatimElevation;
  }

  public void setVerbatimElevation(String verbatimElevation) {
    this.verbatimElevation = verbatimElevation;
  }

  public String getMinimumDepthInMeters() {
    return minimumDepthInMeters;
  }

  public void setMinimumDepthInMeters(String minimumDepthInMeters) {
    this.minimumDepthInMeters = minimumDepthInMeters;
  }

  public String getMaximumDepthInMeters() {
    return maximumDepthInMeters;
  }

  public void setMaximumDepthInMeters(String maximumDepthInMeters) {
    this.maximumDepthInMeters = maximumDepthInMeters;
  }

  public String getVerbatimDepth() {
    return verbatimDepth;
  }

  public void setVerbatimDepth(String verbatimDepth) {
    this.verbatimDepth = verbatimDepth;
  }

  public String getMinimumDistanceAboveSurfaceInMeters() {
    return minimumDistanceAboveSurfaceInMeters;
  }

  public void setMinimumDistanceAboveSurfaceInMeters(String minimumDistanceAboveSurfaceInMeters) {
    this.minimumDistanceAboveSurfaceInMeters = minimumDistanceAboveSurfaceInMeters;
  }

  public String getMaximumDistanceAboveSurfaceInMeters() {
    return maximumDistanceAboveSurfaceInMeters;
  }

  public void setMaximumDistanceAboveSurfaceInMeters(String maximumDistanceAboveSurfaceInMeters) {
    this.maximumDistanceAboveSurfaceInMeters = maximumDistanceAboveSurfaceInMeters;
  }

  public String getLocationAccordingTo() {
    return locationAccordingTo;
  }

  public void setLocationAccordingTo(String locationAccordingTo) {
    this.locationAccordingTo = locationAccordingTo;
  }

  public String getLocationRemarks() {
    return locationRemarks;
  }

  public void setLocationRemarks(String locationRemarks) {
    this.locationRemarks = locationRemarks;
  }

  public BigDecimal getDecimalLatitude() {
    return decimalLatitude;
  }

  public void setDecimalLatitude(BigDecimal decimalLatitude) {
    this.decimalLatitude = decimalLatitude;
  }

  public BigDecimal getDecimalLongitude() {
    return decimalLongitude;
  }

  public void setDecimalLongitude(BigDecimal decimalLongitude) {
    this.decimalLongitude = decimalLongitude;
  }

  public String getGeodeticDatum() {
    return geodeticDatum;
  }

  public void setGeodeticDatum(String geodeticDatum) {
    this.geodeticDatum = geodeticDatum;
  }

  public Double getCoordinateUncertaintyInMeters() {
    return coordinateUncertaintyInMeters;
  }

  public void setCoordinateUncertaintyInMeters(Double coordinateUncertaintyInMeters) {
    this.coordinateUncertaintyInMeters = coordinateUncertaintyInMeters;
  }

  public String getCoordinatePrecision() {
    return coordinatePrecision;
  }

  public void setCoordinatePrecision(String coordinatePrecision) {
    this.coordinatePrecision = coordinatePrecision;
  }

  public String getPointRadiusSpatialFit() {
    return pointRadiusSpatialFit;
  }

  public void setPointRadiusSpatialFit(String pointRadiusSpatialFit) {
    this.pointRadiusSpatialFit = pointRadiusSpatialFit;
  }

  public String getVerbatimCoordinates() {
    return verbatimCoordinates;
  }

  public void setVerbatimCoordinates(String verbatimCoordinates) {
    this.verbatimCoordinates = verbatimCoordinates;
  }

  public String getVerbatimLatitude() {
    return verbatimLatitude;
  }

  public void setVerbatimLatitude(String verbatimLatitude) {
    this.verbatimLatitude = verbatimLatitude;
  }

  public String getVerbatimLongitude() {
    return verbatimLongitude;
  }

  public void setVerbatimLongitude(String verbatimLongitude) {
    this.verbatimLongitude = verbatimLongitude;
  }

  public String getVerbatimCoordinateSystem() {
    return verbatimCoordinateSystem;
  }

  public void setVerbatimCoordinateSystem(String verbatimCoordinateSystem) {
    this.verbatimCoordinateSystem = verbatimCoordinateSystem;
  }

  public String getVerbatimSRS() {
    return verbatimSRS;
  }

  public void setVerbatimSRS(String verbatimSRS) {
    this.verbatimSRS = verbatimSRS;
  }

  public String getFootprintWKT() {
    return footprintWKT;
  }

  public void setFootprintWKT(String footprintWKT) {
    this.footprintWKT = footprintWKT;
  }

  public String getFootprintSRS() {
    return footprintSRS;
  }

  public void setFootprintSRS(String footprintSRS) {
    this.footprintSRS = footprintSRS;
  }

  public String getFootprintSpatialFit() {
    return footprintSpatialFit;
  }

  public void setFootprintSpatialFit(String footprintSpatialFit) {
    this.footprintSpatialFit = footprintSpatialFit;
  }

  public String getGeoreferencedBy() {
    return georeferencedBy;
  }

  public void setGeoreferencedBy(String georeferencedBy) {
    this.georeferencedBy = georeferencedBy;
  }

  public Date getGeoreferencedDate() {
    return georeferencedDate;
  }

  public void setGeoreferencedDate(Date georeferencedDate) {
    this.georeferencedDate = georeferencedDate;
  }

  public String getGeoreferenceProtocol() {
    return georeferenceProtocol;
  }

  public void setGeoreferenceProtocol(String georeferenceProtocol) {
    this.georeferenceProtocol = georeferenceProtocol;
  }

  public String getGeoreferenceSources() {
    return georeferenceSources;
  }

  public void setGeoreferenceSources(String georeferenceSources) {
    this.georeferenceSources = georeferenceSources;
  }

  public String getGeoreferenceVerificationStatus() {
    return georeferenceVerificationStatus;
  }

  public void setGeoreferenceVerificationStatus(String georeferenceVerificationStatus) {
    this.georeferenceVerificationStatus = georeferenceVerificationStatus;
  }

  public String getGeoreferenceRemarks() {
    return georeferenceRemarks;
  }

  public void setGeoreferenceRemarks(String georeferenceRemarks) {
    this.georeferenceRemarks = georeferenceRemarks;
  }

  public String getGeologicalContextID() {
    return geologicalContextID;
  }

  public void setGeologicalContextID(String geologicalContextID) {
    this.geologicalContextID = geologicalContextID;
  }

  public String getEarliestEonOrLowestEonothem() {
    return earliestEonOrLowestEonothem;
  }

  public void setEarliestEonOrLowestEonothem(String earliestEonOrLowestEonothem) {
    this.earliestEonOrLowestEonothem = earliestEonOrLowestEonothem;
  }

  public String getLatestEonOrHighestEonothem() {
    return latestEonOrHighestEonothem;
  }

  public void setLatestEonOrHighestEonothem(String latestEonOrHighestEonothem) {
    this.latestEonOrHighestEonothem = latestEonOrHighestEonothem;
  }

  public String getEarliestEraOrLowestErathem() {
    return earliestEraOrLowestErathem;
  }

  public void setEarliestEraOrLowestErathem(String earliestEraOrLowestErathem) {
    this.earliestEraOrLowestErathem = earliestEraOrLowestErathem;
  }

  public String getLatestEraOrHighestErathem() {
    return latestEraOrHighestErathem;
  }

  public void setLatestEraOrHighestErathem(String latestEraOrHighestErathem) {
    this.latestEraOrHighestErathem = latestEraOrHighestErathem;
  }

  public String getEarliestPeriodOrLowestSystem() {
    return earliestPeriodOrLowestSystem;
  }

  public void setEarliestPeriodOrLowestSystem(String earliestPeriodOrLowestSystem) {
    this.earliestPeriodOrLowestSystem = earliestPeriodOrLowestSystem;
  }

  public String getLatestPeriodOrHighestSystem() {
    return latestPeriodOrHighestSystem;
  }

  public void setLatestPeriodOrHighestSystem(String latestPeriodOrHighestSystem) {
    this.latestPeriodOrHighestSystem = latestPeriodOrHighestSystem;
  }

  public String getEarliestEpochOrLowestSeries() {
    return earliestEpochOrLowestSeries;
  }

  public void setEarliestEpochOrLowestSeries(String earliestEpochOrLowestSeries) {
    this.earliestEpochOrLowestSeries = earliestEpochOrLowestSeries;
  }

  public String getLatestEpochOrHighestSeries() {
    return latestEpochOrHighestSeries;
  }

  public void setLatestEpochOrHighestSeries(String latestEpochOrHighestSeries) {
    this.latestEpochOrHighestSeries = latestEpochOrHighestSeries;
  }

  public String getEarliestAgeOrLowestStage() {
    return earliestAgeOrLowestStage;
  }

  public void setEarliestAgeOrLowestStage(String earliestAgeOrLowestStage) {
    this.earliestAgeOrLowestStage = earliestAgeOrLowestStage;
  }

  public String getLatestAgeOrHighestStage() {
    return latestAgeOrHighestStage;
  }

  public void setLatestAgeOrHighestStage(String latestAgeOrHighestStage) {
    this.latestAgeOrHighestStage = latestAgeOrHighestStage;
  }

  public String getLowestBiostratigraphicZone() {
    return lowestBiostratigraphicZone;
  }

  public void setLowestBiostratigraphicZone(String lowestBiostratigraphicZone) {
    this.lowestBiostratigraphicZone = lowestBiostratigraphicZone;
  }

  public String getHighestBiostratigraphicZone() {
    return highestBiostratigraphicZone;
  }

  public void setHighestBiostratigraphicZone(String highestBiostratigraphicZone) {
    this.highestBiostratigraphicZone = highestBiostratigraphicZone;
  }

  public String getLithostratigraphicTerms() {
    return lithostratigraphicTerms;
  }

  public void setLithostratigraphicTerms(String lithostratigraphicTerms) {
    this.lithostratigraphicTerms = lithostratigraphicTerms;
  }

  public String getGroup() {
    return group;
  }

  public void setGroup(String group) {
    this.group = group;
  }

  public String getFormation() {
    return formation;
  }

  public void setFormation(String formation) {
    this.formation = formation;
  }

  public String getMember() {
    return member;
  }

  public void setMember(String member) {
    this.member = member;
  }

  public String getBed() {
    return bed;
  }

  public void setBed(String bed) {
    this.bed = bed;
  }

  public String getIdentificationID() {
    return identificationID;
  }

  public void setIdentificationID(String identificationID) {
    this.identificationID = identificationID;
  }

  public String getIdentificationQualifier() {
    return identificationQualifier;
  }

  public void setIdentificationQualifier(String identificationQualifier) {
    this.identificationQualifier = identificationQualifier;
  }

  public String getTypeStatus() {
    return typeStatus;
  }

  public void setTypeStatus(String typeStatus) {
    this.typeStatus = typeStatus;
  }

  public String getIdentifiedBy() {
    return identifiedBy;
  }

  public void setIdentifiedBy(String identifiedBy) {
    this.identifiedBy = identifiedBy;
  }

  public Date getDateIdentified() {
    return dateIdentified;
  }

  public void setDateIdentified(Date dateIdentified) {
    this.dateIdentified = dateIdentified;
  }

  public String getIdentificationReferences() {
    return identificationReferences;
  }

  public void setIdentificationReferences(String identificationReferences) {
    this.identificationReferences = identificationReferences;
  }

  public String getIdentificationVerificationStatus() {
    return identificationVerificationStatus;
  }

  public void setIdentificationVerificationStatus(String identificationVerificationStatus) {
    this.identificationVerificationStatus = identificationVerificationStatus;
  }

  public String getIdentificationRemarks() {
    return identificationRemarks;
  }

  public void setIdentificationRemarks(String identificationRemarks) {
    this.identificationRemarks = identificationRemarks;
  }

  public String getTaxonID() {
    return taxonID;
  }

  public void setTaxonID(String taxonID) {
    this.taxonID = taxonID;
  }

  public String getScientificNameID() {
    return scientificNameID;
  }

  public void setScientificNameID(String scientificNameID) {
    this.scientificNameID = scientificNameID;
  }

  public String getAcceptedNameUsageID() {
    return acceptedNameUsageID;
  }

  public void setAcceptedNameUsageID(String acceptedNameUsageID) {
    this.acceptedNameUsageID = acceptedNameUsageID;
  }

  public String getParentNameUsageID() {
    return parentNameUsageID;
  }

  public void setParentNameUsageID(String parentNameUsageID) {
    this.parentNameUsageID = parentNameUsageID;
  }

  public String getOriginalNameUsageID() {
    return originalNameUsageID;
  }

  public void setOriginalNameUsageID(String originalNameUsageID) {
    this.originalNameUsageID = originalNameUsageID;
  }

  public String getNameAccordingToID() {
    return nameAccordingToID;
  }

  public void setNameAccordingToID(String nameAccordingToID) {
    this.nameAccordingToID = nameAccordingToID;
  }

  public String getNamePublishedInID() {
    return namePublishedInID;
  }

  public void setNamePublishedInID(String namePublishedInID) {
    this.namePublishedInID = namePublishedInID;
  }

  public String getTaxonConceptID() {
    return taxonConceptID;
  }

  public void setTaxonConceptID(String taxonConceptID) {
    this.taxonConceptID = taxonConceptID;
  }

  public String getScientificName() {
    return scientificName;
  }

  public void setScientificName(String scientificName) {
    this.scientificName = scientificName;
  }

  public String getAcceptedNameUsage() {
    return acceptedNameUsage;
  }

  public void setAcceptedNameUsage(String acceptedNameUsage) {
    this.acceptedNameUsage = acceptedNameUsage;
  }

  public String getParentNameUsage() {
    return parentNameUsage;
  }

  public void setParentNameUsage(String parentNameUsage) {
    this.parentNameUsage = parentNameUsage;
  }

  public String getOriginalNameUsage() {
    return originalNameUsage;
  }

  public void setOriginalNameUsage(String originalNameUsage) {
    this.originalNameUsage = originalNameUsage;
  }

  public String getNameAccordingTo() {
    return nameAccordingTo;
  }

  public void setNameAccordingTo(String nameAccordingTo) {
    this.nameAccordingTo = nameAccordingTo;
  }

  public String getNamePublishedIn() {
    return namePublishedIn;
  }

  public void setNamePublishedIn(String namePublishedIn) {
    this.namePublishedIn = namePublishedIn;
  }

  public String getNamePublishedInYear() {
    return namePublishedInYear;
  }

  public void setNamePublishedInYear(String namePublishedInYear) {
    this.namePublishedInYear = namePublishedInYear;
  }

  public String getHigherClassification() {
    return higherClassification;
  }

  public void setHigherClassification(String higherClassification) {
    this.higherClassification = higherClassification;
  }

  public String getKingdom() {
    return kingdom;
  }

  public void setKingdom(String kingdom) {
    this.kingdom = kingdom;
  }

  public String getPhylum() {
    return phylum;
  }

  public void setPhylum(String phylum) {
    this.phylum = phylum;
  }

  public String getClazz() {
    return clazz;
  }

  public void setClazz(String clazz) {
    this.clazz = clazz;
  }

  public String getOrder() {
    return order;
  }

  public void setOrder(String order) {
    this.order = order;
  }

  public String getFamily() {
    return family;
  }

  public void setFamily(String family) {
    this.family = family;
  }

  public String getGenus() {
    return genus;
  }

  public void setGenus(String genus) {
    this.genus = genus;
  }

  public String getSubgenus() {
    return subgenus;
  }

  public void setSubgenus(String subgenus) {
    this.subgenus = subgenus;
  }

  public String getSpecificEpithet() {
    return specificEpithet;
  }

  public void setSpecificEpithet(String specificEpithet) {
    this.specificEpithet = specificEpithet;
  }

  public String getInfraspecificEpithet() {
    return infraspecificEpithet;
  }

  public void setInfraspecificEpithet(String infraspecificEpithet) {
    this.infraspecificEpithet = infraspecificEpithet;
  }

  public String getTaxonRank() {
    return taxonRank;
  }

  public void setTaxonRank(String taxonRank) {
    this.taxonRank = taxonRank;
  }

  public String getVerbatimTaxonRank() {
    return verbatimTaxonRank;
  }

  public void setVerbatimTaxonRank(String verbatimTaxonRank) {
    this.verbatimTaxonRank = verbatimTaxonRank;
  }

  public String getScientificNameAuthorship() {
    return scientificNameAuthorship;
  }

  public void setScientificNameAuthorship(String scientificNameAuthorship) {
    this.scientificNameAuthorship = scientificNameAuthorship;
  }

  public String getVernacularName() {
    return vernacularName;
  }

  public void setVernacularName(String vernacularName) {
    this.vernacularName = vernacularName;
  }

  public String getNomenclaturalCode() {
    return nomenclaturalCode;
  }

  public void setNomenclaturalCode(String nomenclaturalCode) {
    this.nomenclaturalCode = nomenclaturalCode;
  }

  public String getTaxonomicStatus() {
    return taxonomicStatus;
  }

  public void setTaxonomicStatus(String taxonomicStatus) {
    this.taxonomicStatus = taxonomicStatus;
  }

  public String getNomenclaturalStatus() {
    return nomenclaturalStatus;
  }

  public void setNomenclaturalStatus(String nomenclaturalStatus) {
    this.nomenclaturalStatus = nomenclaturalStatus;
  }

  public String getTaxonRemarks() {
    return taxonRemarks;
  }

  public void setTaxonRemarks(String taxonRemarks) {
    this.taxonRemarks = taxonRemarks;
  }

  public String getGuid() {
    return guid;
  }

  public void setGuid(String guid) {
    this.guid = guid;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (id != null ? id.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof SimpleDwc)) {
      return false;
    }
    SimpleDwc other = (SimpleDwc) object;
    return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
  }

  @Override
  public String toString() {
    return "se.nrm.bas.specify.gbif.datamodel.SimpleDwc[ id=" + id + " ]";
  }
  
}
