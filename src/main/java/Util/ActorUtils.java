package Util;

import java.util.List;

import Dao.Actor_Imp;
import Model.Actor;

public class ActorUtils {
	Actor_Imp actor_Imp = new Actor_Imp();
	String jpql_getofMovie = "Select a form Actor a where a.id = :id_movie a.id =";
	
	public List<Actor> getallActor_ofMovie() {
		return actor_Imp.getList_ByCondition(jpql_getofMovie, null, null);
	}	
	
}
