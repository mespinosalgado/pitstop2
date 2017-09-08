package cl.pitstop.hibernateDao;

import java.util.List;

import cl.pitstop.dao.RevisionDao;
import cl.pitstop.pojos.Revision;

public class RevisionHibernateDao extends AbstractDao implements RevisionDao {
	
	public RevisionHibernateDao(){
		super(Revision.class);
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Revision> revisionAll(){
		return (List<Revision>) super.findAll();
	}
		
	@SuppressWarnings("deprecation")
	public void updRevision(Revision revision){
		super.update(revision);
	}
	
	public void delRevision(Revision revision){
		super.delete(revision);
	}


	@Override
	@SuppressWarnings("deprecation")
	public void crearRevision(Revision revision) {
		super.insert(revision);
		
	}
	
}
