package org.example;

import org.example.dao.*;
import org.example.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Main {
    private final SessionFactory sessionFactory;

    private final ActorDAO actorDAO;
    private final AddressDAO addressDAO;
    private final CategoryDAO categoryDAO;
    private final CityDAO cityDAO;
    private final CountryDAO countryDAO;
    private final CustomerDAO customerDAO;
    private final FilmDAO filmDAO;
    private final FilmTextDAO filmTextDAO;
    private final InventoryDAO inventoryDAO;
    private final LanguageDAO languageDAO;
    private final PaymentDAO paymentDAO;
    private final RentalDAO rentalDAO;
    private final StaffDAO staffDAO;
    private final StoreDAO storeDAO;
    public Main() {
        sessionFactory = new Configuration()
            .addAnnotatedClass(Actor.class)
            .addAnnotatedClass(Address.class)
            .addAnnotatedClass(Category.class)
            .addAnnotatedClass(City.class)
            .addAnnotatedClass(Country.class)
            .addAnnotatedClass(Customer.class)
            .addAnnotatedClass(Film.class)
            .addAnnotatedClass(FilmText.class)
            .addAnnotatedClass(Inventory.class)
            .addAnnotatedClass(Language.class)
            .addAnnotatedClass(Payment.class)
            .addAnnotatedClass(Rental.class)
            .addAnnotatedClass(Staff.class)
            .addAnnotatedClass(Store.class)
            .buildSessionFactory();

        actorDAO = new ActorDAO(sessionFactory);
        addressDAO = new AddressDAO(sessionFactory);
        categoryDAO = new CategoryDAO(sessionFactory);
        cityDAO = new CityDAO(sessionFactory);
        countryDAO = new CountryDAO(sessionFactory);
        customerDAO = new CustomerDAO(sessionFactory);
        filmDAO = new FilmDAO(sessionFactory);
        filmTextDAO = new FilmTextDAO(sessionFactory);
        inventoryDAO = new InventoryDAO(sessionFactory);
        languageDAO = new LanguageDAO(sessionFactory);
        paymentDAO = new PaymentDAO(sessionFactory);
        rentalDAO = new RentalDAO(sessionFactory);
        staffDAO = new StaffDAO(sessionFactory);
        storeDAO = new StoreDAO(sessionFactory);
    }
    public static void main(String[] args) {
        Main main = new Main();
       Customer customer = main.createNewCustomer();
       // main.returnRentalMovie();
        main.customerRentInv(customer);
    }

    private void customerRentInv(Customer customer) {
        try(Session session = sessionFactory.getCurrentSession()) {
            Transaction transaction = session.beginTransaction();

            Store store = storeDAO.getItems(0, 1).get(0);
            Film film = filmDAO.getAvaliableFilmToRent();

            Inventory inventory = new Inventory();
            inventory.setFilm(film);
            inventory.setStore(store);
            inventoryDAO.create(inventory);

            Staff staff = store.getStaff();

            Rental rental = new Rental();
            rental.setCustomer(customer);
            rental.setRentalDate(LocalDateTime.now());
            rental.setInventory(inventory);
            rental.setStaff(staff);
            rentalDAO.create(rental);

            Payment payment = new Payment();
            payment.setCustomer(customer);
            payment.setRental(rental);
            payment.setStaff(staff);
            payment.setAmount(BigDecimal.valueOf(245.5));
            payment.setPaymentDate(LocalDateTime.now());
            paymentDAO.create(payment);

            transaction.commit();
        }
    }

    private Customer createNewCustomer() {
        try (Session session = sessionFactory.getCurrentSession()){
            Transaction transaction = session.beginTransaction();
            Store store = storeDAO.getItems(0, 1).get(0);

            City city = cityDAO.getByName("Arak");

            Address address = new Address();
            address.setAddress("12 street");
            address.setCity(city);
            address.setDistrict("Brooklyn");
            address.setPhone("2888-547-896");
            addressDAO.create(address);

            Customer customer = new Customer();
            customer.setFirstName("Ivan");
            customer.setLastName("Gromov");
            customer.setEmail("grom@gmail.com");
            customer.setAddress(address);
            customer.setActive(true);
            customer.setStore(store);
            customerDAO.create(customer);

            transaction.commit();
            return customer;
        }
    }
    private void returnRentalMovie() {
        try (Session session = sessionFactory.getCurrentSession()) {
            Transaction transaction = session.beginTransaction();

            Rental rental = rentalDAO.getUnreturnedRental();
            rental.setReturnDate(LocalDateTime.now());

            transaction.commit();
        }
    }
}