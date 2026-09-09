require python3-labgrid.inc

SRC_URI += "git://github.com/labgrid-project/labgrid.git;protocol=https;branch=${SRCBRANCH}"

SRCBRANCH = "master"
SRCREV = "14113c308e2f82195c39ad8b175aca093a1506e7"

PV = "26.0+git"

LABGRID_USE_DEVEL_VERSION[doc] = "Global switch to enable labgrid development (git) version"
LABGRID_USE_DEVEL_VERSION ??= "-1"
DEFAULT_PREFERENCE ??= "${LABGRID_USE_DEVEL_VERSION}"
