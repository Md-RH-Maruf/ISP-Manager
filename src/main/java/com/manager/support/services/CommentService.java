package com.manager.support.services;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manager.accounts.entity.CommentDetails;
import com.manager.example.entityModel.TicketDetails;
import com.manager.support.entity.Comment;
import com.manager.support.entity.McInformation;
import com.manager.support.entity.WorkTeam;
import com.manager.support.repository.CommentRepository;
import com.manager.support.repository.McInfoRepository;
import com.manager.support.repository.WorkTeamRepository;

@Service
public class CommentService {

	@Autowired
	CommentRepository commentRepo;
	
	@Autowired
	private EntityManagerFactory emf;
	@PersistenceContext
	EntityManager em;
	
	SimpleDateFormat dateFormate = new SimpleDateFormat("dd-MMM-yyyy HH:mm");
	
	public Comment saveComment(Comment comment) {
		return commentRepo.save(comment);
	}
	
	public Comment getComment(long id) {
		return commentRepo.findById(id).orElse(null);
	}
	
	@SuppressWarnings("unchecked")
	@Transactional
	public List<CommentDetails> getCommentsByTmsNo(String tmsNo){
		em = emf.createEntityManager();
		em.getTransaction().begin();
		List<CommentDetails> commentList = new ArrayList<>();
		List<Object[]> results = em.createQuery("SELECT c.id,c.ticketId,c.commentString,u.username,c.entryTime \r\n" + 
				"FROM Comment c\r\n" + 
				"LEFT JOIN User u\r\n" + 
				"ON c.entryBy = u.id\r\n" + 
				"WHERE c.ticketId = '"+tmsNo+"'").getResultList();
		
		for(Object[] obj:results) {
			
			commentList.add(new CommentDetails((Long)obj[0], obj[1].toString(), obj[2].toString(), obj[3].toString(), obj[4].toString()));
		}
		em.getTransaction().commit();
		em.close();
		return commentList;
		
	}
}
