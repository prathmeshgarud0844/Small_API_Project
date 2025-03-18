
package com.demo.model

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "producttab11")
 data class Product(
   @Id
    var pid: Int = 0,
   var name: String? = null,
   var qty: Int = 0,
   var price: Double = 0.0
)

