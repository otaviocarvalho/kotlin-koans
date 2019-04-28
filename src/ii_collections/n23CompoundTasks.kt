package ii_collections

fun Shop.getCustomersWhoOrderedProduct(product: Product): Set<Customer> {
    // Return the set of customers who ordered the specified product
    return this.customers.filter {
        it.orders.filter { it.products.contains(product) }.isNotEmpty()
    }.toSet()
//    todoCollectionTask()
}

fun Customer.getMostExpensiveDeliveredProduct(): Product? {
    // Return the most expensive product among all delivered products
    // (use the Order.isDelivered flag)
    return this.orders
            .filter { it.isDelivered }
            .flatMap { it.products }
            .maxBy { it.price }
//    todoCollectionTask()
}

fun Shop.getNumberOfTimesProductWasOrdered(product: Product): Int {
    return this.customers.flatMap { it.orders.flatMap { it.products } }
            .filter { it.name == product.name }
            .size
    // Return the number of times the given product was ordered.
    // Note: a customer may order the same product for several times.
//    todoCollectionTask()
}
