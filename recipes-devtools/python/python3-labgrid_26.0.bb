require python3-labgrid.inc

inherit pypi

SRC_URI[sha256sum] = "686695d3fa8c0ac0c9a6e6b42f9c8e9e92a9363c9d4945718e5fc21e431bd3d8"

SRC_URI += "file://0001-remote-client-Drop-exceptiongroup.patch"

# The 26.0 sdist still lists "wheel" in [build-system] requires. Since
# oe-core commit 80d7499d9973 ("classes/python_setuptools_build_meta: remove
# wheel dependency") the class no longer provides python3-wheel-native, so
# pyproject-build's --no-isolation dependency check fails. Upstream dropped
# the requirement after 26.0 in labgrid commit f424fcd30e6c ("pyproject.toml:
# drop wheel build requirement"), so this can go with the next upgrade.
DEPENDS += "python3-wheel-native"
