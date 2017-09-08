package cl.pitstop.dao;

import java.util.List;

import cl.pitstop.pojos.Revision;

public interface RevisionDao extends GenericDao {
	
	public List<Revision>  revisionAll();
	
	public void crearRevision(Revision reviciones);

}
