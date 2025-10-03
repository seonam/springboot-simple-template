package kr.seonam.springboot.template.core.domain.user.fixture

import com.navercorp.fixturemonkey.kotlin.giveMeKotlinBuilder
import com.navercorp.fixturemonkey.kotlin.setExp
import kr.seonam.springboot.template.core.common.FixtureUtil
import kr.seonam.springboot.template.core.domain.user.model.User

object UserFixture {
    fun any(): User =
        FixtureUtil
            .monkey()
            .giveMeKotlinBuilder<User>()
            .setExp(User::id, 0)
            .sample()
}
