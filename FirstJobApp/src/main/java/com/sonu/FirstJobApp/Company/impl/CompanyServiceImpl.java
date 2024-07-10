package com.sonu.FirstJobApp.Company.impl;

import com.sonu.FirstJobApp.Company.Company;
import com.sonu.FirstJobApp.Company.CompanyRepository;
import com.sonu.FirstJobApp.Company.CompanyService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImpl implements CompanyService {
    private CompanyRepository companyRepository;

    public CompanyServiceImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    @Override
    public boolean updateCompany(Company company, Long id) {
        Optional<Company>companyOptional=companyRepository.findById(id);
        return false;
    }


}
