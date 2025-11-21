package com.example.merchants.service;

import com.example.merchants.entity.Merchants;
import com.example.merchants.repository.MerchantsRepository;
import org.springframework.stereotype.Service;

@Service
public class MerchantsService {
    private final MerchantsRepository repo;
    public MerchantsService(MerchantsRepository repo){ this.repo = repo; }
    public Merchants create(Merchants m){ return repo.save(m); }
    public Merchants get(Integer id){ return repo.findById(id).orElse(null); }
    public Merchants audit(Integer id, boolean pass){ Merchants m = get(id); if(m==null) return null; m.setIsAudit(pass); return repo.save(m); }
}
