package kr.seonam.springboot.template.core.domain.user.fixture

import com.navercorp.fixturemonkey.kotlin.giveMeBuilder
import kr.disdong.springboot.template.redis.domain.user.dto.UserCache
import kr.seonam.springboot.template.core.common.FixtureUtil

object UserCacheFixture {
    fun any(): UserCache =
        FixtureUtil
            .monkey()
            .giveMeBuilder<UserCache>()
            .sample()
}
