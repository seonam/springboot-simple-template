# Springboot simple template

[springboot-template](https://github.com/seonam/springboot-template) 에서 순수 도메인 계층을 제거한 템플릿입니다.

### Set conventional commits

```
# Install dependencies
npm install @commitlint/cli @commitlint/config-conventional --save-dev

# Configure commitlint
echo "module.exports = { extends: ['@commitlint/config-conventional'] };" > commitlint.config.js

# Install husky
npx husky init

# Configure commit-msg
echo "npx --no -- commitlint --edit \$1" > .husky/commit-msg

# Remove pre-commit if you don't need
rm .husky/pre-commit
```


### Reference
- https://www.conventionalcommits.org/en/v1.0.0/
- https://medium.com/@abpeter14/how-to-install-commitlint-husky-2024-f1157f14006f