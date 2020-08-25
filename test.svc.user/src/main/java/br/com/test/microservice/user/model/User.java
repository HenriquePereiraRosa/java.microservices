//package br.com.test.microservice.user.model;
//
//import com.credta.gamerscard.core.hibernate.converter.UserStatusConverter;
//import com.credta.gamerscard.core.jackson.views.Views;
//import com.credta.gamerscard.model.entity.*;
//import com.credta.gamerscard.model.entity.financial.BCAccount;
//import com.credta.gamerscard.model.valueobject.SessionDetails;
//import com.credta.gamerscard.model.valueobject.UserStatus;
//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
//import com.fasterxml.jackson.annotation.JsonInclude;
//import com.fasterxml.jackson.annotation.JsonProperty;
//import com.fasterxml.jackson.annotation.JsonView;
//import lombok.Data;
//import lombok.EqualsAndHashCode;
//import lombok.ToString;
//import org.hibernate.annotations.Type;
//
//import javax.persistence.*;
//import java.io.Serializable;
//import java.math.BigDecimal;
//import java.util.Date;
//import java.util.List;
//import java.util.Objects;
//import java.util.Set;
//
//@Entity
//@Table(name = "User")
//@JsonInclude(JsonInclude.Include.NON_EMPTY)
//@JsonIgnoreProperties(value = { "password", "passToken",  "shortPassToken", "passTokenExpiration", "hibernateLazyInitializer", "handler", "bankAccounts" })
//@NamedEntityGraph(name = "User.detail", attributeNodes = { @NamedAttributeNode("userDetail"),  @NamedAttributeNode("cards") })
//public class User implements Serializable {
//
//	private static final long serialVersionUID = 1L;
//
//	@Id
//    @GeneratedValue(strategy=GenerationType.IDENTITY)
//    @Column(name = "id", unique = true, nullable = false)
//    private Long id;
//
// 	@ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "accountId", referencedColumnName = "id")
// 	@JsonProperty(value = "Account")
//    private Account account;
//
//// 	@OneToOne(fetch = FetchType.LAZY, mappedBy = "user", optional = false, cascade = CascadeType.REMOVE)
// 	@JsonProperty(value = "UserDetail")
// 	private UserDetail userDetail;
//
// 	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
// 	@JsonProperty("UserCards")
// 	private Set<Card> cards;
//
// 	@ManyToOne()
//    @JoinColumn(name = "profileId", referencedColumnName = "id")
//    private Profile profile;
//
//    @Column(name = "email")
//    private String email;
//
//    @Column(name = "password")
//    private String password;
//
//    @Column(name = "apiKey")
//    private String apiKey;
//
//    @JsonView(Views.ShortVersion.class)
//    @Column(name = "firstName")
//    private String firstName;
//
//    @JsonView(Views.ShortVersion.class)
//    @Column(name = "lastName")
//    private String lastName;
//
//    @Column(name = "phoneNumber")
//    private String phoneNumber;
//
//    @Convert(converter = UserStatusConverter.class)
//    @Column(name = "status")
//    private UserStatus status;
//
//    @Column(name = "deleted")
//    private Boolean deleted;
//
//    @Column(name = "shortPassToken")
//    private String shortPassToken;
//
//    @Column(name = "passToken")
//    private String passToken;
//
//    @Column(name = "tokenAdesao")
//    private String tokenAdesao;
//
//    @Temporal(TemporalType.TIMESTAMP)
//    @Column(name = "passTokenExpiration")
//    private Date passTokenExpiration;
//
//    @Temporal(TemporalType.TIMESTAMP)
//    @Column(name = "lastLoginDate")
//    private Date lastLoginDate;
//
//    @Temporal(TemporalType.TIMESTAMP)
//    @Column(name = "lastChangeDate")
//    private Date lastChangeDate;
//
//    @Temporal(TemporalType.TIMESTAMP)
//    @Column(name = "lastFailDate")
//    private Date lastFailDate;
//
//    @Temporal(TemporalType.TIMESTAMP)
//    @Column(name = "joinDate")
//    private Date joinDate;
//
//    @Column(name = "balance", nullable = false)
//    private BigDecimal balance;
//
//    @Type(type = "json")
//    @Column(columnDefinition = "text")
//    private SessionDetails sessionDetails;
//
//    @Column(name = "clientCode")
//    private String clientCode;
//
//    @Transient
//    private String currentProxy;
//
//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
// 	@JsonProperty("CardOrders")
//    private List<CardOrder> cardOrders;
//
//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user", orphanRemoval = true, cascade = CascadeType.ALL)
//    @JsonProperty("Subscriptions")
//    Set<UserSubscription> subscriptions;
//
//    @ManyToOne(fetch = FetchType.LAZY, optional = true)
//    @JoinColumn(name = "affiliateId", referencedColumnName = "id")
//    private Affiliate affiliate;
//
//    @ManyToMany(fetch = FetchType.LAZY)
//    @JoinTable(name = "UserGame", joinColumns =
//    	@JoinColumn(name = "userId"),
//		inverseJoinColumns = @JoinColumn(name = "gameId"))
//    private Set<Game> gamesOfInterest;
//
//    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    private Set<UserAccountToken> assignedTokens;
//
//    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    private List<BCAccount> bankAccounts;
//
//    public User() {}
//
//    public User(Long id) {
//    	this.id = id;
//    }
//
//    public static long getSerialVersionUID() {
//        return serialVersionUID;
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public Account getAccount() {
//        return account;
//    }
//
//    public void setAccount(Account account) {
//        this.account = account;
//    }
//
//    public UserDetail getUserDetail() {
//        return userDetail;
//    }
//
//    public void setUserDetail(UserDetail userDetail) {
//        this.userDetail = userDetail;
//    }
//
//    public Set<Card> getCards() {
//        return cards;
//    }
//
//    public void setCards(Set<Card> cards) {
//        this.cards = cards;
//    }
//
//    public Profile getProfile() {
//        return profile;
//    }
//
//    public void setProfile(Profile profile) {
//        this.profile = profile;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    public String getApiKey() {
//        return apiKey;
//    }
//
//    public void setApiKey(String apiKey) {
//        this.apiKey = apiKey;
//    }
//
//    public String getFirstName() {
//        return firstName;
//    }
//
//    public void setFirstName(String firstName) {
//        this.firstName = firstName;
//    }
//
//    public String getLastName() {
//        return lastName;
//    }
//
//    public void setLastName(String lastName) {
//        this.lastName = lastName;
//    }
//
//    public String getPhoneNumber() {
//        return phoneNumber;
//    }
//
//    public void setPhoneNumber(String phoneNumber) {
//        this.phoneNumber = phoneNumber;
//    }
//
//    public UserStatus getStatus() {
//        return status;
//    }
//
//    public void setStatus(UserStatus status) {
//        this.status = status;
//    }
//
//    public Boolean getDeleted() {
//        return deleted;
//    }
//
//    public void setDeleted(Boolean deleted) {
//        this.deleted = deleted;
//    }
//
//    public String getShortPassToken() {
//        return shortPassToken;
//    }
//
//    public void setShortPassToken(String shortPassToken) {
//        this.shortPassToken = shortPassToken;
//    }
//
//    public String getPassToken() {
//        return passToken;
//    }
//
//    public void setPassToken(String passToken) {
//        this.passToken = passToken;
//    }
//
//    public String getTokenAdesao() {
//        return tokenAdesao;
//    }
//
//    public void setTokenAdesao(String tokenAdesao) {
//        this.tokenAdesao = tokenAdesao;
//    }
//
//    public Date getPassTokenExpiration() {
//        return passTokenExpiration;
//    }
//
//    public void setPassTokenExpiration(Date passTokenExpiration) {
//        this.passTokenExpiration = passTokenExpiration;
//    }
//
//    public Date getLastLoginDate() {
//        return lastLoginDate;
//    }
//
//    public void setLastLoginDate(Date lastLoginDate) {
//        this.lastLoginDate = lastLoginDate;
//    }
//
//    public Date getLastChangeDate() {
//        return lastChangeDate;
//    }
//
//    public void setLastChangeDate(Date lastChangeDate) {
//        this.lastChangeDate = lastChangeDate;
//    }
//
//    public Date getLastFailDate() {
//        return lastFailDate;
//    }
//
//    public void setLastFailDate(Date lastFailDate) {
//        this.lastFailDate = lastFailDate;
//    }
//
//    public Date getJoinDate() {
//        return joinDate;
//    }
//
//    public void setJoinDate(Date joinDate) {
//        this.joinDate = joinDate;
//    }
//
//    public BigDecimal getBalance() {
//        return balance;
//    }
//
//    public void setBalance(BigDecimal balance) {
//        this.balance = balance;
//    }
//
//    public SessionDetails getSessionDetails() {
//        return sessionDetails;
//    }
//
//    public void setSessionDetails(SessionDetails sessionDetails) {
//        this.sessionDetails = sessionDetails;
//    }
//
//    public String getClientCode() {
//        return clientCode;
//    }
//
//    public void setClientCode(String clientCode) {
//        this.clientCode = clientCode;
//    }
//
//    public String getCurrentProxy() {
//        return currentProxy;
//    }
//
//    public void setCurrentProxy(String currentProxy) {
//        this.currentProxy = currentProxy;
//    }
//
//    public List<CardOrder> getCardOrders() {
//        return cardOrders;
//    }
//
//    public void setCardOrders(List<CardOrder> cardOrders) {
//        this.cardOrders = cardOrders;
//    }
//
//    public Set<UserSubscription> getSubscriptions() {
//        return subscriptions;
//    }
//
//    public void setSubscriptions(Set<UserSubscription> subscriptions) {
//        this.subscriptions = subscriptions;
//    }
//
//    public Affiliate getAffiliate() {
//        return affiliate;
//    }
//
//    public void setAffiliate(Affiliate affiliate) {
//        this.affiliate = affiliate;
//    }
//
//    public Set<Game> getGamesOfInterest() {
//        return gamesOfInterest;
//    }
//
//    public void setGamesOfInterest(Set<Game> gamesOfInterest) {
//        this.gamesOfInterest = gamesOfInterest;
//    }
//
//    public Set<UserAccountToken> getAssignedTokens() {
//        return assignedTokens;
//    }
//
//    public void setAssignedTokens(Set<UserAccountToken> assignedTokens) {
//        this.assignedTokens = assignedTokens;
//    }
//
//    public List<BCAccount> getBankAccounts() {
//        return bankAccounts;
//    }
//
//    public void setBankAccounts(List<BCAccount> bankAccounts) {
//        this.bankAccounts = bankAccounts;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        User user = (User) o;
//        return id.equals(user.id) &&
//                Objects.equals(email, user.email);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(id, email);
//    }
//}
