package com.myapp.buildlogic.plugins

import com.android.build.api.dsl.ApplicationExtension
import com.android.build.api.dsl.ApplicationProductFlavor
import com.android.build.api.dsl.CommonExtension
import com.android.build.api.dsl.ProductFlavor

/*
 * Project: MyApplication
 * File: ConfigureFlavors
 *
 * Created by: charvin on 8/25/24.
 * Last modified by: charvin on 8/25/24.
 *
 * Description:
 * 
 */



enum class FlavorType {
    DEVELOPMENT,
    PRODUCTION,
}

enum class Flavor(val dimension: FlavorType, val applicationIdSuffix: String? = null) {
    DEVELOPMENT(FlavorType.DEVELOPMENT, ".dev"),
    FREE(FlavorType.PRODUCTION, ".free"),
    PAID(FlavorType.PRODUCTION, ".paid")
}

@Suppress("UnstableApiUsage")
fun configureFlavors(
    commonExtension: CommonExtension<*, *, *, *, *, *, *, *>,
    flavorConfigurationBlock: ProductFlavor.(flavor: Flavor) -> Unit = {}
) {
    commonExtension.apply {
        flavorDimensions += FlavorType.PRODUCTION.name
        flavorDimensions += FlavorType.DEVELOPMENT.name
        // fun productFlavors(action: Action<NamedDomainObjectContainer<ProductFlavorT>>)
        Flavor.values().forEach { flavor ->
            productFlavors.create(flavor.name) { it ->
                it as ProductFlavor
                it.dimension = flavor.dimension.name
                flavorConfigurationBlock(it, flavor)
                if (this@apply is ApplicationExtension && this is ApplicationProductFlavor<*>) {
                    if (flavor.applicationIdSuffix != null) {
                        applicationIdSuffix = flavor.applicationIdSuffix
                    }
                }
            }
        }
    }
}