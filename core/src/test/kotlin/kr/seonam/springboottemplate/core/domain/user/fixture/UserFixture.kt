package kr.seonam.springboottemplate.core.domain.user.fixture

import com.navercorp.fixturemonkey.kotlin.giveMeKotlinBuilder
import kr.seonam.springboottemplate.core.common.FixtureUtil
import kr.seonam.springboottemplate.core.domain.user.model.User

object UserFixture {
    /**
     * TODO.
     */
    fun any(): User =
        FixtureUtil
            .monkey()
            .giveMeKotlinBuilder<User>()
            .setExp(User::id, 0)
            .setExp(User::name, "hi")
            .setExp(User::phone, "0987654321")
            .sample()
}
