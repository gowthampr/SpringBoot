package com.company.gp.library.repo;

import org.springframework.data.jpa.repository.*;

import com.company.gp.library.entity.Book;

public interface BookRepository extends JpaRepository<Book,Long>{

}
