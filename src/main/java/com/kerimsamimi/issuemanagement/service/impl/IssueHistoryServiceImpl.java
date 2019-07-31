package com.kerimsamimi.issuemanagement.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.kerimsamimi.issuemanagement.entity.IssueHistory;
import com.kerimsamimi.issuemanagement.repository.IssueHsitoryRepository;
import com.kerimsamimi.issuemanagement.service.IssueHistoryService;

@Service
public class IssueHistoryServiceImpl implements IssueHistoryService {
	
	@Autowired
	private IssueHsitoryRepository issueHistoryRepository;

	@Override
	public IssueHistory save(IssueHistory issueHistory) {
		if(issueHistory.getDate()==null) {
			throw new IllegalArgumentException("Issue cannot be null");
		}
		issueHistory= issueHistoryRepository.save(issueHistory);
		return issueHistory;
	}

	@Override
	public IssueHistory getById(Long id) {
		return issueHistoryRepository.getOne(id);
	}

	@Override
	public Page<IssueHistory> getAllPageable(Pageable pageable) {
		return issueHistoryRepository.findAll(pageable);
	}

	@Override
	public Boolean delete(IssueHistory issueHistory) {
		issueHistoryRepository.delete(issueHistory);
		return Boolean.TRUE;
	}

}
