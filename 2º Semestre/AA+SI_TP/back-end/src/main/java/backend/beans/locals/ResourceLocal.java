package backend.beans.locals;

import backend.dao.Resources;
import backend.json.*;

import javax.ejb.Local;

@Local
public interface ResourceLocal {
    Resources createResource(CreateResourceJSON crj);
    Resources updateResource(UpdateResourceJSON crj, int idUser);
    TypesJSON[] getResourceTypes();
    ResourceJSON[] getResources(int idUser);
    ResourceJSON[] getResourcesOfType(String t, int idUser);
    ResourceJSON getResource(int id, int idUser);
    RatingsJSON rateResource(int id, int idUser, RateResourceJSON rrj);
    ResourceJSON incDownloads(int id);
    ResourceJSON delResource(int id, int idUser);
    ResourceJSON[] getRecentResources(int idUser);
}
