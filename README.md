# Lazy Loading - carregamento preguiçoso/só funciona quando necessário
## ToMany - Por padrão tudo que termina com "ToMany" usa a estratégia Lazy Loading, ou seja, uma estratégia de carregamento preguiçosa.
### 1. É um carregamento por demanda. Precisou, o JPA vai dar um jeito de buscar o que preciso:
````
	@ManyToMany
    @JoinTable(name = "restaurant_payment_form",
            joinColumns = @JoinColumn(name = "restaurant_id"),
            inverseJoinColumns = @JoinColumn(name = "payment_form_id"))
    private List<PaymentForm> paymentForms = new ArrayList<>();
````