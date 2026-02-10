package kr.seonam.springboottemplate.core.domain.user.fixture

import com.navercorp.fixturemonkey.kotlin.giveMeBuilder
import kr.disdong.springboottemplate.redis.domain.user.dto.UserCache
import kr.seonam.springboottemplate.core.common.FixtureUtil

object UserCacheFixture {
    fun any(): UserCache =
        FixtureUtil
            .monkey()
            .giveMeBuilder<UserCache>()
            .sample()
}
