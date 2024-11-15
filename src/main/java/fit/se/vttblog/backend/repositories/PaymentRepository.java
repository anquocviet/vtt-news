package fit.se.vttblog.backend.repositories;

import fit.se.vttblog.backend.entities.Payment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PaymentRepository extends CrudRepository<Payment, String>, PagingAndSortingRepository<Payment, String> {
}