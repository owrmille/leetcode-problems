#!/usr/bin/env bash
set -euo pipefail

# Usage:
#   ./rm_lc.sh "33. Search in Rotated Sorted Array"
#   ./rm_lc.sh "33"
#
# It will locate the corresponding package folder under:
#   src/main/java/io/github/owrmille/leetcode/
#   src/test/java/io/github/owrmille/leetcode/
#   src/test/resources/leetcode/
#
# and delete that task's directory in each location after confirmation.

BASE_PKG="io.github.owrmille.leetcode"
BASE_PATH_MAIN="src/main/java/$(echo "$BASE_PKG" | tr '.' '/')"
BASE_PATH_TEST="src/test/java/$(echo "$BASE_PKG" | tr '.' '/')"
BASE_PATH_RES="src/test/resources/leetcode"

INPUT="${1:-}"
if [[ -z "$INPUT" ]]; then
  echo "Usage: $0 \"33. Search in Rotated Sorted Array\"  OR  $0 \"33\""
  exit 1
fi

# Extract problem id (supports "33", "33.", "33 - ...", "33. ...")
if [[ "$INPUT" =~ ^[[:space:]]*([0-9]+) ]]; then
  ID="${BASH_REMATCH[1]}"
else
  echo "Could not parse problem id from input: $INPUT"
  exit 1
fi

printf -v ID_PAD "%04d" "$ID"
PREFIX="p${ID_PAD}_"

# Find matching directories (there should be at most one under each base)
find_match() {
  local base="$1"
  if [[ ! -d "$base" ]]; then
    echo ""
    return
  fi
  # shellcheck disable=SC2012
  local matches
  matches=$(ls -1 "$base" 2>/dev/null | grep -E "^${PREFIX}" || true)
  local count
  count=$(printf '%s\n' "$matches" | sed '/^$/d' | wc -l | tr -d ' ')
  if [[ "$count" -eq 0 ]]; then
    echo ""
  elif [[ "$count" -eq 1 ]]; then
    printf '%s\n' "$matches"
  else
    echo "__MULTI__"
    printf '%s\n' "$matches"
  fi
}

MAIN_MATCH="$(find_match "$BASE_PATH_MAIN")"
TEST_MATCH="$(find_match "$BASE_PATH_TEST")"
RES_MATCH="$(find_match "$BASE_PATH_RES")"

# Handle multiple matches safely
if [[ "$MAIN_MATCH" == "__MULTI__"* || "$TEST_MATCH" == "__MULTI__"* || "$RES_MATCH" == "__MULTI__"* ]]; then
  echo "Found multiple folders matching ID $ID (prefix $PREFIX). Refusing to delete."
  echo
  echo "Matches:"
  echo "  main: $(printf '%s' "$MAIN_MATCH" | sed '1{/__MULTI__/d}')"
  echo "  test: $(printf '%s' "$TEST_MATCH" | sed '1{/__MULTI__/d}')"
  echo "  res : $(printf '%s' "$RES_MATCH"  | sed '1{/__MULTI__/d}')"
  echo
  echo "Please rename folders to be unique or delete manually."
  exit 1
fi

TASK_DIR=""
# Prefer main match as authoritative, fall back to test/res
if [[ -n "$MAIN_MATCH" ]]; then
  TASK_DIR="$MAIN_MATCH"
elif [[ -n "$TEST_MATCH" ]]; then
  TASK_DIR="$TEST_MATCH"
elif [[ -n "$RES_MATCH" ]]; then
  TASK_DIR="$RES_MATCH"
else
  echo "No folders found for problem ID $ID (prefix $PREFIX). Nothing to delete."
  exit 0
fi

MAIN_PATH="${BASE_PATH_MAIN}/${TASK_DIR}"
TEST_PATH="${BASE_PATH_TEST}/${TASK_DIR}"
RES_PATH="${BASE_PATH_RES}/${TASK_DIR}"

echo "About to remove LeetCode task for ID $ID:"
[[ -d "$MAIN_PATH" ]] && echo "  - $MAIN_PATH"
[[ -d "$TEST_PATH" ]] && echo "  - $TEST_PATH"
[[ -d "$RES_PATH"  ]] && echo "  - $RES_PATH"

if [[ ! -d "$MAIN_PATH" && ! -d "$TEST_PATH" && ! -d "$RES_PATH" ]]; then
  echo "No existing directories to delete."
  exit 0
fi

echo
read -r -p "Type 'yes' to confirm deletion: " CONFIRM
if [[ "$CONFIRM" != "yes" ]]; then
  echo "Aborted."
  exit 0
fi

# Perform deletions
rm -rf "$MAIN_PATH" 2>/dev/null || true
rm -rf "$TEST_PATH" 2>/dev/null || true
rm -rf "$RES_PATH"  2>/dev/null || true

echo "Deleted task directories for ID $ID (folder: $TASK_DIR)."