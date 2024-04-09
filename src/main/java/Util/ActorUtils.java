package Util;

import java.util.List;

import Dao.Actor_Imp;
import Model.Actor;

public class ActorUtils {
	Actor_Imp actor_Imp = new Actor_Imp();
	String jpql_getofMovie = "Select a form Actor a where a.id = :id_movie a.id =";
	String jpql_getAllMovie = "Select a form Actor a";
	
	public List<Actor> getallActor_ofMovie() {
		return actor_Imp.getList_ByCondition(jpql_getofMovie, null, null);
	}
	
	public List<Actor> getallActor() {
		return actor_Imp.getAll();
	}
	
}
